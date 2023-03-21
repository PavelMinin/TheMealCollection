package com.example.search.viewmodel

import com.example.core.data.model.MealOverview

data class SearchFragmentViewState(
    val loading: Boolean = false,
    val meals: List<MealOverview> = emptyList()
)
