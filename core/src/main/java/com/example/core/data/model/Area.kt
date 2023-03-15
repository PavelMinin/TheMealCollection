package com.example.core.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class AreasWrapper(
    val meals: List<Area>
)

@Serializable
data class Area(
    @SerializedName("strArea")
    val name: String
)

