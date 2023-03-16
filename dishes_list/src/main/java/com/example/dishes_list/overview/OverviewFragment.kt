package com.example.dishes_list.overview

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core.data.NetworkUnavailable
import com.example.core.utils.Utils
import com.example.core.utils.Utils.addHorizontalSpaceDecoration
import com.example.core.utils.viewBinding
import com.example.dishes_list.R
import com.example.dishes_list.databinding.FragmentOverviewBinding
import com.example.dishes_list.overview.adapter.MealAdapter
import com.example.dishes_list.overview.di.OverviewComponentViewModel
import com.example.navigation.BaseFragment
import com.google.android.material.snackbar.Snackbar
import dagger.Lazy
import javax.inject.Inject


class OverviewFragment : BaseFragment(R.layout.fragment_overview) {

    @Inject
    internal lateinit var overviewViewModelFactory: Lazy<OverviewViewModelFactory>

    private val binding by viewBinding(FragmentOverviewBinding::bind)
    private val viewModel: OverviewViewModel by viewModels {
        overviewViewModelFactory.get()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        ViewModelProvider(this).get<OverviewComponentViewModel>()
            .newOverviewComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        requestMealList()
    }

    private fun setupUI() {
        val adapter = createAdapter()
        setupRecyclerView(adapter)
        observeViewStateUpdates(adapter)
    }

    private fun createAdapter(): MealAdapter {
        return MealAdapter { meal ->
            findNavController().navigate(
            OverviewFragmentDirections.actionFragmentOverviewPageToNavUserDetails(meal)
        )
            findNavController() }
    }

    private fun setupRecyclerView(adapter: MealAdapter) {
        binding.recyclerView.apply {
            setAdapter(adapter)
            this.addHorizontalSpaceDecoration(Utils.RECYCLER_ITEM_SPACE)
        }
    }

    private fun observeViewStateUpdates(adapter: MealAdapter) {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewState.collect { updateUi(it, adapter) }
        }
    }

    private fun updateUi(viewState: OverviewFragmentViewState, adapter: MealAdapter) {
        adapter.submitList(viewState.meals)
        binding.loadingProgressBar.isVisible = viewState.loading
    }
    private fun subscribeToViewEffects() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewEffects.collect {
                when (it) {
                    is OverviewFragmentViewEffects.Failure -> handleFailure(it.cause)
                }
            }
        }
    }

    private fun handleFailure(cause: Throwable) {
        binding.loadingProgressBar.isInvisible = true

        val message = when (cause) {
            is NetworkUnavailable -> getString(R.string.network_unavailable_error_message)
            else -> getString(R.string.generic_error_message)
        }

        showSnackbar(message)
    }


    private fun showSnackbar(message: String) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()
    }

    private fun requestMealList() {
        viewModel.requestMealList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}

