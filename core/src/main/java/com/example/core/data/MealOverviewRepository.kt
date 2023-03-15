package com.example.core.data

import com.example.core.data.model.MealOverview
import kotlinx.coroutines.flow.Flow

interface MealOverviewRepository {

    fun getMealList(): Flow<List<MealOverview>>
}