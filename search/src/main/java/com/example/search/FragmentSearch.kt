package com.example.search

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.data.NetworkUnavailable
import com.example.core.utils.Utils
import com.example.core.utils.Utils.addHorizontalSpaceDecoration
import com.example.core.utils.viewBinding
import com.example.navigation.BaseFragment
import com.example.search.adapter.MealAdapter
import com.example.search.databinding.SearchFragmentBinding
import com.example.search.di.SearchComponentViewModel
import com.example.search.viewmodel.SearchFragmentViewEffects
import com.example.search.viewmodel.SearchFragmentViewState
import com.example.search.viewmodel.SearchViewModel
import com.example.search.viewmodel.SearchViewModelFactory
import com.google.android.material.snackbar.Snackbar
import dagger.Lazy
import javax.inject.Inject
class FragmentSearch : BaseFragment(R.layout.search_fragment) {

    @Inject
    internal lateinit var overviewViewModelFactory: Lazy<SearchViewModelFactory>

    private val binding by viewBinding(SearchFragmentBinding::bind)
    private val viewModel: SearchViewModel by viewModels {
        overviewViewModelFactory.get()
    }

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<SearchComponentViewModel>()
            .searchComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        setOnSearchButtonListener()
    }

    private fun setOnSearchButtonListener() {
        with(binding) {
            arrowSearchImg.setOnClickListener {
                viewModel.searchRequest(searchLine.text.toString())
            }
        }
    }

    private fun setupUI() {
        val adapter = createAdapter()
        setupRecyclerView(adapter)
        observeViewStateUpdates(adapter)
        subscribeToViewEffects()
    }

    private fun createAdapter(): MealAdapter {
        return MealAdapter { mealId ->
            findNavController().navigate(
            FragmentSearchDirections
                .actionFragmentSearchPageToNavMealDetails(mealId)
        ) }
    }

    private fun setupRecyclerView(adapter: MealAdapter) {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.VERTICAL, false)
            setAdapter(adapter)
            this.addHorizontalSpaceDecoration(Utils.RECYCLER_ITEM_SPACE)
        }
    }

    private fun observeViewStateUpdates(adapter: MealAdapter) {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewState.collect { updateUi(it, adapter) }
        }
    }

    private fun updateUi(viewState: SearchFragmentViewState, adapter: MealAdapter) {
        adapter.submitList(viewState.meals)
        binding.loadingProgressBar.isVisible = viewState.loading
    }
    private fun subscribeToViewEffects() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewEffects.collect {
                when(it) {
                    is SearchFragmentViewEffects.Failure -> handleFailure(it.cause)
                }
            }
        }
    }

    private fun handleFailure(cause: Throwable) {
        binding.loadingProgressBar.isVisible = false

        val message = when (cause) {
            is NetworkUnavailable -> getString(R.string.network_unavailable_error_message)
            else -> getString(R.string.generic_error_message)
        }
        showSnackbar(message)
    }


    private fun showSnackbar(message: String) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()
    }
}

