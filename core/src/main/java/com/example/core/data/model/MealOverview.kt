package com.example.core.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class MealWrapper(
    val meals: List<MealOverview>
)
@Serializable
data class MealOverview(
    @SerializedName("idMeal")
    val id: String,
    @SerializedName("strMeal")
    val name: String?,
    @SerializedName("strArea")
    val area: String?,
    @SerializedName("strCategory")
    val category: String?,
    @SerializedName("strMealThumb")
    val imageUrl: String?
)