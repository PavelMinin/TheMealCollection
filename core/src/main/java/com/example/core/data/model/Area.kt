package com.example.core.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class AreasWrapper(
    val areas: List<Area>
)

@Serializable
data class Area(
    @SerializedName("strArea")
    val name: String
)

