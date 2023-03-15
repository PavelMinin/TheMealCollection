package com.example.core.db.dao

import androidx.room.*
import com.example.core.db.model.AreaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AreaDao {
    @Query("SELECT * FROM area_property WHERE name=:name")
    fun get(name: String): Flow<AreaEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(property: List<AreaEntity>)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(property: AreaEntity)
    @Delete
    fun delete(property: AreaEntity)
    @Query("SELECT * FROM area_property")
    fun getAll(): Flow<List<AreaEntity>>
}