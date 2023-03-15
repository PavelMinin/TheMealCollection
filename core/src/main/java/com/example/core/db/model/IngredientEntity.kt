package com.example.core.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.data.model.Ingredient

@Entity(tableName = "ingredient_property")
data class IngredientEntity (
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
)

fun IngredientEntity.asExternalModel() = Ingredient(
    id = id,
    description = description,
    name = name
)
