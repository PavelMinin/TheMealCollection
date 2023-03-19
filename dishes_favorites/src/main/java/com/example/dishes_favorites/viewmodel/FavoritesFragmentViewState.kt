package com.example.dishes_favorites.viewmodel

import com.example.core.data.model.MealDetails

data class FavoritesFragmentViewState(
    val loading: Boolean = true,
    val meals: List<MealDetails> = emptyList()
)
