package com.example.core.db.di

import android.content.Context
import androidx.room.Room
import com.example.core.db.MealDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideMealDatabase(
        context: Context
    ): MealDatabase = Room.databaseBuilder(
        context,
        MealDatabase::class.java,
        "meal_database"
    ).build()
}