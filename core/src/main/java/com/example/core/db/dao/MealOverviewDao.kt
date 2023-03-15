package com.example.core.db.dao

import androidx.room.*
import com.example.core.db.model.MealOverviewEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MealOverviewDao {
    @Query("SELECT * FROM meal_overview_property WHERE id=:id")
    fun get(id: String): Flow<MealOverviewEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(property: List<MealOverviewEntity>)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(property: MealOverviewEntity)
    @Delete
    fun delete(property: MealOverviewEntity)
    @Query("SELECT * FROM meal_overview_property")
    fun getAll(): Flow<List<MealOverviewEntity>>
}