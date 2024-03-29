package com.example.core.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class IngredientsWrapper(
    val ingredients: List<Ingredient>
)

@Serializable
data class Ingredient(
    @SerializedName("idIngredient")
    val id: String,
    @SerializedName("strDescription")
    val description: String,
    @SerializedName("strIngredient")
    val name: String,
)