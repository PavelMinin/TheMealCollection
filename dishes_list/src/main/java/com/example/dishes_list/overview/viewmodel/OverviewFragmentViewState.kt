package com.example.dishes_list.overview.viewmodel

import com.example.core.data.model.MealOverview

data class OverviewFragmentViewState(
    val loading: Boolean = true,
    val meals: List<MealOverview> = emptyList()
)
