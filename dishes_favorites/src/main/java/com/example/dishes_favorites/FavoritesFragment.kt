package com.example.dishes_favorites

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
import com.example.dishes_favorites.adapter.MealAdapter
import com.example.dishes_favorites.databinding.FragmentFavoritesBinding
import com.example.dishes_favorites.di.FavoritesComponentViewModel
import com.example.dishes_favorites.viewmodel.FavoritesFragmentViewEffects
import com.example.dishes_favorites.viewmodel.FavoritesFragmentViewState
import com.example.dishes_favorites.viewmodel.FavoritesViewModel
import com.example.dishes_favorites.viewmodel.FavoritesViewModelFactory
import com.example.navigation.BaseFragment
import com.google.android.material.snackbar.Snackbar
import dagger.Lazy
import javax.inject.Inject


class FavoritesFragment : BaseFragment(R.layout.fragment_favorites) {

    @Inject
    internal lateinit var favoritesViewModelFactory: Lazy<FavoritesViewModelFactory>

    private val binding by viewBinding(FragmentFavoritesBinding::bind)
    private val viewModel: FavoritesViewModel by viewModels {
        favoritesViewModelFactory.get()
    }

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<FavoritesComponentViewModel>()
            .newFavoritesComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        requestFavoritesList()
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
                FavoritesFragmentDirections
                    .actionFragmentFavoritesPageToNavUserDetails(mealId)
            )
        }
    }

    private fun setupRecyclerView(adapter: MealAdapter) {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.VERTICAL, false
            )
            setAdapter(adapter)
            this.addHorizontalSpaceDecoration(Utils.RECYCLER_ITEM_SPACE)
        }
    }

    private fun observeViewStateUpdates(adapter: MealAdapter) {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewState.collect { updateUi(it, adapter) }
        }
    }

    private fun updateUi(viewState: FavoritesFragmentViewState, adapter: MealAdapter) {
        adapter.submitList(viewState.meals)
        binding.loadingProgressBar.isVisible = viewState.loading
    }

    private fun subscribeToViewEffects() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewEffects.collect {
                when (it) {
                    is FavoritesFragmentViewEffects.Failure -> handleFailure(it.cause)
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

    private fun requestFavoritesList() {
        viewModel.requestFavoritesList()
    }
}

