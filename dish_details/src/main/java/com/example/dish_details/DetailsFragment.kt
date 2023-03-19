package com.example.dish_details

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.core.data.NetworkUnavailable
import com.example.core.data.model.MealDetails
import com.example.core.utils.viewBinding
import com.example.dish_details.databinding.FragmentDetailsBinding
import com.example.dish_details.di.DetailsComponentViewModel
import com.example.dish_details.viewmodel.DetailsFragmentViewEffects
import com.example.dish_details.viewmodel.DetailsFragmentViewState
import com.example.dish_details.viewmodel.DetailsViewModel
import com.example.dish_details.viewmodel.DetailsViewModelFactory
import com.example.navigation.BaseFragment
import com.google.android.material.snackbar.Snackbar
import dagger.Lazy
import javax.inject.Inject


class DetailsFragment : BaseFragment(R.layout.fragment_details) {

    @Inject
    internal lateinit var detailsViewModelFactory: Lazy<DetailsViewModelFactory>

    private val binding by viewBinding(FragmentDetailsBinding::bind)
    private val viewModel: DetailsViewModel by viewModels {
        detailsViewModelFactory.get()
    }

    private val args by navArgs<DetailsFragmentArgs>()

    init {
        needShowBottomBar = false
    }

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<DetailsComponentViewModel>()
            .newDetailsComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        requestMealDetails(args.mealId)
        setOnFavoritesClickListener()
        setOnToolbarBackButtonListener()
    }

    private fun setOnToolbarBackButtonListener() {
        binding.toolbarDetail.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setOnFavoritesClickListener() {
        binding.favoritesIcon.setOnClickListener {
            viewModel.pressOnFavoritesButton()
        }
    }

    private fun requestMealDetails(id: String) {
        viewModel.requestMealDetails(id)
    }

    private fun setupUI() {
        observeViewStateUpdates()
        subscribeToViewEffects()
    }

    private fun observeViewStateUpdates() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewState.collect { updateUi(it) }
        }
    }

    private fun subscribeToViewEffects() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewEffects.collect {
                when (it) {
                    is DetailsFragmentViewEffects.Failure -> handleFailure(it.cause)
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
        showLocalData()
    }

    private fun showLocalData() {
        viewModel.setLocalData(args.mealId)
    }


    private fun showSnackbar(message: String) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()
    }

    private fun updateUi(viewState: DetailsFragmentViewState) {
        viewState.mealDetails?.let { showDetails(it) }
        binding.loadingProgressBar.isVisible = viewState.loading
        binding.favoritesIcon.isVisible = viewState.loading
        if(viewState.isFavorites) {
            binding.favoritesIcon.setImageResource(R.drawable.baseline_favorite_24)
        } else {
            binding.favoritesIcon.setImageResource(R.drawable.baseline_favorite_border_24)
        }
    }

    private fun showDetails(mealDetails: MealDetails) {
        val details = requireNotNull(mealDetails) { "Details is null!" }
        with(binding) {
            toolbarDetail.title = details.name
            toolbarDetail.subtitle = details.category
            image.load(details.imageUrl)
            favoritesIcon.drawable
            val mapOfingredientsAndMeasures = makeIngredientAndMeasuresMap(mealDetails)
            var ingredients = ""
            var firstLine = true
            mapOfingredientsAndMeasures.forEach {
                if(it.key != null) {
                    if(firstLine) {
                        firstLine = false
                        ingredients += (it.key + ": ") + (it.value  ?: "\nN/A")
                    }
                    ingredients += "\n" + (it.key + ": ") + (it.value  ?: "\nN/A")
                }
            }
            ingredientsField.text = ingredients
            instructionsField.text = details.strInstructions
        }
    }

    private fun makeIngredientAndMeasuresMap(mealDetails: MealDetails): Map<String?, String?> {
        with(mealDetails) {
            return mapOf(
                strIngredient1 to strMeasure1,
                strIngredient2 to strMeasure2,
                strIngredient3 to strMeasure3,
                strIngredient4 to strMeasure4,
                strIngredient5 to strMeasure5,
                strIngredient6 to strMeasure6,
                strIngredient7 to strMeasure7,
                strIngredient8 to strMeasure8,
                strIngredient9 to strMeasure9,
                strIngredient10 to strMeasure10,
                strIngredient11 to strMeasure11,
                strIngredient12 to strMeasure12,
                strIngredient13 to strMeasure13,
                strIngredient14 to strMeasure14,
                strIngredient15 to strMeasure15,
                strIngredient16 to strMeasure16,
                strIngredient17 to strMeasure17,
                strIngredient18 to strMeasure18,
                strIngredient19 to strMeasure19,
                strIngredient20 to strMeasure20
            )
        }
    }
}