package com.example.core.db.dao

import androidx.room.*
import com.example.core.db.model.MealFavoritesEntity


@Dao
interface MealFavoritesDao {
    @Query("SELECT * FROM meal_favorites_property WHERE id=:id")
    fun get(id: String): MealFavoritesEntity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(property: MealFavoritesEntity)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(property: MealFavoritesEntity)
    @Delete
    fun delete(property: MealFavoritesEntity)
    @Query("SELECT * FROM meal_favorites_property")
    fun getAll(): List<MealFavoritesEntity>
}