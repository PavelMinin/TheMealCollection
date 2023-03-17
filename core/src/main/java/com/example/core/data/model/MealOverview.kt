package com.example.core.data.model

import com.example.core.db.model.MealOverviewEntity
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
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
): java.io.Serializable

fun MealOverview.asInternalModel() = MealOverviewEntity(
    id = id,
    name = name,
    area = area,
    category = category,
    imageUrl = imageUrl
)