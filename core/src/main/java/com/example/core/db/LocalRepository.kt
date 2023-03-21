package com.example.core.data

import android.content.Context
import com.example.core.db.MealDatabase
import com.example.core.db.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface LocalRepository {

    suspend fun getMealList(): Result<List<MealOverviewEntity>>

    suspend fun getMealDetails(id: String): Result<MealFavoritesEntity?>

    suspend fun getMealFavorites(): Result<List<MealFavoritesEntity>>

    suspend fun getAreas(): Result<List<AreaEntity>>

    suspend fun getCategories(): Result<List<CategoryEntity>>

    suspend fun getIngredients(): Result<List<IngredientEntity>>

    suspend fun putMealList(meals: List<MealOverviewEntity>)

    suspend fun putMealFavorites(mealDetails: MealFavoritesEntity)

    suspend fun deleteMealFromFavorites(mealDetails: MealFavoritesEntity)

    suspend fun putAreas(): Result<List<AreaEntity>>

    suspend fun putCategories(): Result<List<CategoryEntity>>

    suspend fun putIngredients(): Result<List<IngredientEntity>>
}

class LocalRepositoryImpl @Inject constructor(context: Context) : LocalRepository {

    private val appDatabase = MealDatabase(context)

    override suspend fun getMealList() = withContext(Dispatchers.IO) {
        Result { appDatabase.mealOverviewDao().getAll() }
    }

    override suspend fun getMealDetails(id: String) = withContext(Dispatchers.IO) {
        Result { appDatabase.mealFavoritesDao().get(id) }
    }

    override suspend fun getMealFavorites() = withContext(Dispatchers.IO) {
        Result { appDatabase.mealFavoritesDao().getAll() }
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

    override suspend fun putMealList(meals: List<MealOverviewEntity>) = withContext(Dispatchers.IO) {
        appDatabase.mealOverviewDao().insert(meals)
    }

    override suspend fun putMealFavorites(mealDetails: MealFavoritesEntity) = withContext(Dispatchers.IO) {
        appDatabase.mealFavoritesDao().insert(mealDetails)
    }

    override suspend fun deleteMealFromFavorites(mealDetails: MealFavoritesEntity) = withContext(Dispatchers.IO) {
       appDatabase.mealFavoritesDao().delete(mealDetails)
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