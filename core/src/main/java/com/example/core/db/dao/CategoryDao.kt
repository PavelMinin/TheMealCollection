package com.example.core.db.dao

import androidx.room.*
import com.example.core.db.model.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category_property WHERE id=:id")
    fun get(id: String): Flow<CategoryEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(property: List<CategoryEntity>)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(property: CategoryEntity)
    @Delete
    fun delete(property: CategoryEntity)
    @Query("SELECT * FROM category_property")
    fun getAll(): Flow<List<CategoryEntity>>
}