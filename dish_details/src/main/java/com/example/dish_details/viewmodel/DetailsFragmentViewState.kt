package com.example.dish_details.viewmodel

import com.example.core.data.model.MealDetails

data class DetailsFragmentViewState(
    val loading: Boolean = true,
    val mealDetails: MealDetails? = null,
    val isFavorites: Boolean = true
)
