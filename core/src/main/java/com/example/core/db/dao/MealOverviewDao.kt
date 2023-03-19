package com.example.core.db.dao

import androidx.room.*
import com.example.core.db.model.MealOverviewEntity

@Dao
interface MealOverviewDao {
    @Query("SELECT * FROM meal_overview_property WHERE id=:id")
    fun get(id: String): MealOverviewEntity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(property: List<MealOverviewEntity>)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(property: MealOverviewEntity)
    @Delete
    fun delete(property: MealOverviewEntity)
    @Query("SELECT * FROM meal_overview_property")
    fun getAll(): List<MealOverviewEntity>
}