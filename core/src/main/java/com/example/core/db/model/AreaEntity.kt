package com.example.core.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.data.model.Area

@Entity(tableName = "area_property")
data class AreaEntity (
    @PrimaryKey
    val name: String
)

fun AreaEntity.asExternalModel() = Area(
    name = name
)
