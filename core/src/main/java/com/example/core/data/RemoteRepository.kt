package com.example.core.data

import com.example.core.data.model.*
import com.example.core.network.retrofit.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface RemoteRepository {

    suspend fun getRandomMealList(): Result<List<MealOverview>>

    suspend fun getMealDetails(id: String): Result<MealDetails>

    suspend fun getAreas(): Result<List<Area>>

    suspend fun getCategories(): Result<List<Category>>

    suspend fun getIngredients(): Result<List<Ingredient>>
}

class RemoteRepositoryImpl(private val apiKey: String) : RemoteRepository {

    private val apiService = ApiService(apiKey)
    override suspend fun getRandomMealList() = withContext(Dispatchers.IO) {
        Result {
            var list = emptyList<MealOverview>()
            repeat(10) {
                val randomMeal = apiService.getRandomMeal().meals.first()
                list = list.plusElement(randomMeal)
            }
            list
        }
    }

    override suspend fun getMealDetails(id: String) = withContext(Dispatchers.IO) {
        Result {
            apiService.getMealDetails(id).meals.first()
        }
    }

    override suspend fun getAreas() = withContext(Dispatchers.IO) {
        Result {
            apiService.getListOfAllAreas().areas
        }
    }

    override suspend fun getCategories() = withContext(Dispatchers.IO) {
        Result {
            apiService.getListOfAllCategories().categories
        }
    }

    override suspend fun getIngredients()= withContext(Dispatchers.IO) {
        Result {
            apiService.getListOfAllIngredients().ingredients
        }
    }
}