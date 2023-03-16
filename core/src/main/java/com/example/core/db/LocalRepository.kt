package com.example.core.data

import android.content.Context
import com.example.core.db.MealDatabase
import com.example.core.db.model.*

interface LocalRepository {

    suspend fun getMealList(): Result<List<MealOverviewEntity>>

    suspend fun getMealFavorites(): Result<MealFavoritesEntity>

    suspend fun getAreas(): Result<List<AreaEntity>>

    suspend fun getCategories(): Result<List<CategoryEntity>>

    suspend fun getIngredients(): Result<List<IngredientEntity>>

    suspend fun putMealList(): Result<List<MealOverviewEntity>>

    suspend fun putMealFavorites(): Result<MealFavoritesEntity>

    suspend fun putAreas(): Result<List<AreaEntity>>

    suspend fun putCategories(): Result<List<CategoryEntity>>

    suspend fun putIngredients(): Result<List<IngredientEntity>>
}

class LocalRepositoryImpl(context: Context) : LocalRepository {

    private val appDatabase = MealDatabase(context)

    override suspend fun getMealList(): Result<List<MealOverviewEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMealFavorites(): Result<MealFavoritesEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getAreas(): Result<List<AreaEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCategories(): Result<List<CategoryEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getIngredients(): Result<List<IngredientEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun putMealList(): Result<List<MealOverviewEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun putMealFavorites(): Result<MealFavoritesEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun putAreas(): Result<List<AreaEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun putCategories(): Result<List<CategoryEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun putIngredients(): Result<List<IngredientEntity>> {
        TODO("Not yet implemented")
    }
}