package com.example.core.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.data.model.Category

@Entity(tableName = "category_property")
data class CategoryEntity (
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    val image: String
)

fun CategoryEntity.asExternalModel() = Category(
    id = id,
    name = name,
    description = description,
    image = image
)
