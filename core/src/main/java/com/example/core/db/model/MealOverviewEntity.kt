package com.example.core.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.data.model.MealOverview

@Entity(tableName = "meal_overview_property")
data class MealOverviewEntity (
    @PrimaryKey
    val id: String,
    val name: String?,
    val area: String?,
    val category: String?,
    @ColumnInfo(name = "image_url")
    val imageUrl: String?
)

fun MealOverviewEntity.asExternalModel() = MealOverview(
    id = id,
    name = name,
    area = area,
    category = category,
    imageUrl = imageUrl
)