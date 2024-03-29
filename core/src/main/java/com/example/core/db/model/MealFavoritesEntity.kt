package com.example.core.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.data.model.MealDetails

@Entity(tableName = "meal_favorites_property")
data class MealFavoritesEntity (
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "date_modified")
    val dateModified: String?,
    val area: String,
    val category: String,
    @ColumnInfo(name = "creative_commons_confirmed")
    val strCreativeCommonsConfirmed: String?,
    @ColumnInfo(name = "drink_alternate")
    val strDrinkAlternate: String?,
    @ColumnInfo(name = "image_source")
    val strImageSource: String?,
    @ColumnInfo(name = "ingredient_1")
    val strIngredient1: String?,
    @ColumnInfo(name = "ingredient_10")
    val strIngredient10: String?,
    @ColumnInfo(name = "ingredient_11")
    val strIngredient11: String?,
    @ColumnInfo(name = "ingredient_12")
    val strIngredient12: String?,
    @ColumnInfo(name = "ingredient_13")
    val strIngredient13: String?,
    @ColumnInfo(name = "ingredient_14")
    val strIngredient14: String?,
    @ColumnInfo(name = "ingredient_15")
    val strIngredient15: String?,
    @ColumnInfo(name = "ingredient_16")
    val strIngredient16: String?,
    @ColumnInfo(name = "ingredient_17")
    val strIngredient17: String?,
    @ColumnInfo(name = "ingredient_18")
    val strIngredient18: String?,
    @ColumnInfo(name = "ingredient_19")
    val strIngredient19: String?,
    @ColumnInfo(name = "ingredient_20")
    val strIngredient20: String?,
    @ColumnInfo(name = "ingredient_2")
    val strIngredient2: String?,
    @ColumnInfo(name = "ingredient_3")
    val strIngredient3: String?,
    @ColumnInfo(name = "ingredient_4")
    val strIngredient4: String?,
    @ColumnInfo(name = "ingredient_5")
    val strIngredient5: String?,
    @ColumnInfo(name = "ingredient_6")
    val strIngredient6: String?,
    @ColumnInfo(name = "ingredient_7")
    val strIngredient7: String?,
    @ColumnInfo(name = "ingredient_8")
    val strIngredient8: String?,
    @ColumnInfo(name = "ingredient_9")
    val strIngredient9: String?,
    @ColumnInfo(name = "instructions")
    val strInstructions: String?,
    val name: String?,
    @ColumnInfo(name = "image_url")
    val imageUrl: String?,
    @ColumnInfo(name = "measure_1")
    val strMeasure1: String?,
    @ColumnInfo(name = "measure_10")
    val strMeasure10: String?,
    @ColumnInfo(name = "measure_11")
    val strMeasure11: String?,
    @ColumnInfo(name = "measure_12")
    val strMeasure12: String?,
    @ColumnInfo(name = "measure_13")
    val strMeasure13: String?,
    @ColumnInfo(name = "measure_14")
    val strMeasure14: String?,
    @ColumnInfo(name = "measure_15")
    val strMeasure15: String?,
    @ColumnInfo(name = "measure_16")
    val strMeasure16: String?,
    @ColumnInfo(name = "measure_17")
    val strMeasure17: String?,
    @ColumnInfo(name = "measure_18")
    val strMeasure18: String?,
    @ColumnInfo(name = "measure_19")
    val strMeasure19: String?,
    @ColumnInfo(name = "measure_20")
    val strMeasure20: String?,
    @ColumnInfo(name = "measure_2")
    val strMeasure2: String?,
    @ColumnInfo(name = "measure_3")
    val strMeasure3: String?,
    @ColumnInfo(name = "measure_4")
    val strMeasure4: String?,
    @ColumnInfo(name = "measure_5")
    val strMeasure5: String?,
    @ColumnInfo(name = "measure_6")
    val strMeasure6: String?,
    @ColumnInfo(name = "measure_7")
    val strMeasure7: String?,
    @ColumnInfo(name = "measure_8")
    val strMeasure8: String?,
    @ColumnInfo(name = "measure_9")
    val strMeasure9: String?,
    @ColumnInfo(name = "source")
    val strSource: String?,
    @ColumnInfo(name = "tags")
    val strTags: String?,
    @ColumnInfo(name = "youtube_url")
    val strYoutube: String?
) {
    companion object {
        const val NOT_FOUND = "N/A"
    }
}

fun MealFavoritesEntity.asExternalModel() = MealDetails(
    id = id,
    dateModified = dateModified,
    area = area,
    category = category,
    strCreativeCommonsConfirmed = strCreativeCommonsConfirmed,
    strDrinkAlternate = strDrinkAlternate,
    strImageSource = strImageSource,
    strIngredient1 = strIngredient1,
    strIngredient10 = strIngredient10,
    strIngredient11 = strIngredient11,
    strIngredient12 = strIngredient12,
    strIngredient13 = strIngredient13,
    strIngredient14 = strIngredient14,
    strIngredient15 = strIngredient15,
    strIngredient16 = strIngredient16,
    strIngredient17 = strIngredient17,
    strIngredient18 = strIngredient18,
    strIngredient19 = strIngredient19,
    strIngredient20 = strIngredient20,
    strIngredient2 = strIngredient2,
    strIngredient3 = strIngredient3,
    strIngredient4 = strIngredient4,
    strIngredient5 = strIngredient5,
    strIngredient6 = strIngredient6,
    strIngredient7 = strIngredient7,
    strIngredient8 = strIngredient8,
    strIngredient9 = strIngredient9,
    strInstructions = strInstructions,
    name = name,
    imageUrl = imageUrl,
    strMeasure1 = strMeasure1,
    strMeasure10 = strMeasure10,
    strMeasure11 = strMeasure11,
    strMeasure12 = strMeasure12,
    strMeasure13 = strMeasure13,
    strMeasure14 = strMeasure14,
    strMeasure15 = strMeasure15,
    strMeasure16 = strMeasure16,
    strMeasure17 = strMeasure17,
    strMeasure18 = strMeasure18,
    strMeasure19 = strMeasure19,
    strMeasure20 = strMeasure20,
    strMeasure2 = strMeasure2,
    strMeasure3 = strMeasure3,
    strMeasure4 = strMeasure4,
    strMeasure5 = strMeasure5,
    strMeasure6 = strMeasure6,
    strMeasure7 = strMeasure7,
    strMeasure8 = strMeasure8,
    strMeasure9 = strMeasure9,
    strSource = strSource,
    strTags = strTags,
    strYoutube = strYoutube
)
//fun MealFavoritesEntity?.asExternalModel() = MealDetails(
//    id = this?.id ?: NOT_FOUND,
//    dateModified = this?.dateModified,
//    area = this?.area ?: NOT_FOUND,
//    category = this?.category ?: NOT_FOUND,
//    strCreativeCommonsConfirmed = this?.strCreativeCommonsConfirmed,
//    strDrinkAlternate = this?.strDrinkAlternate,
//    strImageSource = this?.strImageSource,
//    strIngredient1 = this?.strIngredient1,
//    strIngredient10 = this?.strIngredient10,
//    strIngredient11 = this?.strIngredient11,
//    strIngredient12 = this?.strIngredient12,
//    strIngredient13 = this?.strIngredient13,
//    strIngredient14 = this?.strIngredient14,
//    strIngredient15 = this?.strIngredient15,
//    strIngredient16 = this?.strIngredient16,
//    strIngredient17 = this?.strIngredient17,
//    strIngredient18 = this?.strIngredient18,
//    strIngredient19 = this?.strIngredient19,
//    strIngredient20 = this?.strIngredient20,
//    strIngredient2 = this?.strIngredient2,
//    strIngredient3 = this?.strIngredient3,
//    strIngredient4 = this?.strIngredient4,
//    strIngredient5 = this?.strIngredient5,
//    strIngredient6 = this?.strIngredient6,
//    strIngredient7 = this?.strIngredient7,
//    strIngredient8 = this?.strIngredient8,
//    strIngredient9 = this?.strIngredient9,
//    strInstructions = this?.strInstructions,
//    name = this?.name,
//    imageUrl = this?.imageUrl,
//    strMeasure1 = this?.strMeasure1,
//    strMeasure10 = this?.strMeasure10,
//    strMeasure11 = this?.strMeasure11,
//    strMeasure12 = this?.strMeasure12,
//    strMeasure13 = this?.strMeasure13,
//    strMeasure14 = this?.strMeasure14,
//    strMeasure15 = this?.strMeasure15,
//    strMeasure16 = this?.strMeasure16,
//    strMeasure17 = this?.strMeasure17,
//    strMeasure18 = this?.strMeasure18,
//    strMeasure19 = this?.strMeasure19,
//    strMeasure20 = this?.strMeasure20,
//    strMeasure2 = this?.strMeasure2,
//    strMeasure3 = this?.strMeasure3,
//    strMeasure4 = this?.strMeasure4,
//    strMeasure5 = this?.strMeasure5,
//    strMeasure6 = this?.strMeasure6,
//    strMeasure7 = this?.strMeasure7,
//    strMeasure8 = this?.strMeasure8,
//    strMeasure9 = this?.strMeasure9,
//    strSource = this?.strSource,
//    strTags = this?.strTags,
//    strYoutube = this?.strYoutube
//)
