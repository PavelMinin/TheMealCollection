package com.example.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.db.dao.*
import com.example.core.db.model.*

@Database(
    entities = [
        AreaEntity::class,
        CategoryEntity::class,
        IngredientEntity::class,
        MealFavoritesEntity::class,
        MealOverviewEntity::class
    ],
    version = 1
)
abstract class MealDatabase : RoomDatabase() {
    abstract fun areaDao(): AreaDao
    abstract fun categoryDao(): CategoryDao
    abstract fun ingredientDao(): IngredientDao
    abstract fun mealFavoritesDao(): MealFavoritesDao
    abstract fun mealOverviewDao(): MealOverviewDao
}