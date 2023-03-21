package com.example.core.db.dao

import androidx.room.*
import com.example.core.db.model.IngredientEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IngredientDao {
    @Query("SELECT * FROM ingredient_property WHERE id=:id")
    fun get(id: String): Flow<IngredientEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(property: List<IngredientEntity>)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(property: IngredientEntity)
    @Delete
    fun delete(property: IngredientEntity)
    @Query("SELECT * FROM ingredient_property")
    fun getAll(): Flow<List<IngredientEntity>>
}