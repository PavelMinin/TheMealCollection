package com.example.core.network.retrofit

import com.example.core.data.model.*
import com.example.core.network.model.*
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {
    @GET(value = "random.php")
    suspend fun getRandomMeal() : MealWrapper

    @GET(value = "lookup.php")
    suspend fun getMealDetails(
        @Query("i") id: String
    ) : MealDetailsWrapper

    @GET(value = "list.php?i=list")
    suspend fun getListOfAllIngredients() : IngredientsWrapper

    @GET(value = "list.php?a=list")
    suspend fun getListOfAllAreas() : AreasWrapper

    @GET(value = "categories.php")
    suspend fun getListOfAllCategories() : CategoriesWrapper

    @GET(value = "search.php")
    suspend fun getMealByName(
        @Query("s") name: String
    ) : MealWrapper

    @GET(value = "filter.php")
    suspend fun getMealsByCategory(
        @Query("c") category: String
    ) : MealWrapper

    @GET(value = "filter.php")
    suspend fun getMealsByArea(
        @Query("a") area: String
    ) : MealWrapper
}