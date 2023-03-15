package com.example.core.db.di

import com.example.core.db.MealDatabase
import com.example.core.db.dao.*
import dagger.Module
import dagger.Provides

@Module
object DaosModule {
    @Provides
    fun provideAreaDao(
        database: MealDatabase
    ): AreaDao = database.areaDao()

    @Provides
    fun provideCategoryDao(
        database: MealDatabase
    ): CategoryDao = database.categoryDao()

    @Provides
    fun provideIngredientDao(
        database: MealDatabase
    ): IngredientDao = database.ingredientDao()

    @Provides
    fun provideMealFavoritesDao(
        database: MealDatabase
    ): MealFavoritesDao = database.mealFavoritesDao()

    @Provides
    fun provideMealOverviewDao(
        database: MealDatabase
    ): MealOverviewDao = database.mealOverviewDao()
}