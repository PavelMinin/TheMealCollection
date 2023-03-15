package com.example.dishes_list.overview

import androidx.lifecycle.ViewModel
import com.example.core.data.model.MealOverview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.take

class OverviewViewModel : ViewModel() {

    // Initial value of StateFlow
//    private val _data = MutableStateFlow(listOf(MealOverview(
//        id = "Loading",
//        name = null,
//        area = null,
//        category = null,
//        imageUrl = null
//    )))

    private val _data = MutableStateFlow(getTenRandomMeals()).

    // The external immutable StateFlow
    val data: StateFlow<List<MealOverview>> = _data.asStateFlow()

    private val mealList: MutableList<MealOverview>? = null

    fun getTenRandomMeals(): List<MealOverview> {

    }


}