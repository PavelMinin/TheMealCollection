package com.example.core.data.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class MealDetailsTest {

    @Test
    fun meal_details_can_be_mapped_to_meal_details_entity() {
        val networkModel = MealDetails(
            id = "5565",
            dateModified = "16.07.2021",
            area = "Canada",
            category = "Beef",
            strCreativeCommonsConfirmed = "Creative commons confirmed",
            strDrinkAlternate = "Drink alternate",
            strImageSource = "some/url",
            strIngredient1 = "Ingredient number 27",
            strIngredient10 = "Ingredient number 29",
            strIngredient11 = "Ingredient number 30",
            strIngredient12 = "Ingredient number 31",
            strIngredient13 = "Ingredient number 32",
            strIngredient14 = "Ingredient number 33",
            strIngredient15 = "Ingredient number 34",
            strIngredient16 = "Ingredient number 35",
            strIngredient17 = "Ingredient number 36",
            strIngredient18 = "Ingredient number 37",
            strIngredient19 = "Ingredient number 38",
            strIngredient20 = "Ingredient number 39",
            strIngredient2 = "Ingredient number 40",
            strIngredient3 = "Ingredient number 50",
            strIngredient4 = "Ingredient number 60",
            strIngredient5 = "Ingredient number 70",
            strIngredient6 = "Ingredient number 80",
            strIngredient7 = "Ingredient number 90",
            strIngredient8 = "Ingredient number 92",
            strIngredient9 = "Ingredient number 94",
            strInstructions = "Do something with ingredients",
            name = "Meal name",
            imageUrl = "image/url",
            strMeasure1 = "measure of ingredient number 27", 
            strMeasure10 = "measure of ingredient number 29",
            strMeasure11 = "measure of ingredient number 30",
            strMeasure12 = "measure of ingredient number 31",
            strMeasure13 = "measure of ingredient number 32",
            strMeasure14 = "measure of ingredient number 33",
            strMeasure15 = "measure of ingredient number 34",
            strMeasure16 = "measure of ingredient number 35",
            strMeasure17 = "measure of ingredient number 36",
            strMeasure18 = "measure of ingredient number 37",
            strMeasure19 = "measure of ingredient number 38",
            strMeasure20 = "measure of ingredient number 39",
            strMeasure2 = "measure of ingredient number 40",
            strMeasure3 = "measure of ingredient number 50",
            strMeasure4 = "measure of ingredient number 60",
            strMeasure5 = "measure of ingredient number 70",
            strMeasure6 = "measure of ingredient number 80",
            strMeasure7 = "measure of ingredient number 90",
            strMeasure8 = "measure of ingredient number 92",
            strMeasure9 = "measure of ingredient number 94",
            strSource = "Some source",
            strTags = "tags",
            strYoutube = "youtube/url"
        )
        
        val entity = networkModel.asInternalModel()

        assertEquals("5565", entity.id)
        assertEquals("16.07.2021", entity.dateModified)
        assertEquals("Canada", entity.area)
        assertEquals("Beef", entity.category)
        assertEquals("Creative commons confirmed", entity.strCreativeCommonsConfirmed)
        assertEquals("Drink alternate", entity.strDrinkAlternate)
        assertEquals("some/url", entity.strImageSource)
        assertEquals("Ingredient number 27", entity.strIngredient1)
        assertEquals("Ingredient number 29", entity.strIngredient10)
        assertEquals("Ingredient number 30", entity.strIngredient11)
        assertEquals("Ingredient number 31", entity.strIngredient12)
        assertEquals("Ingredient number 32", entity.strIngredient13)
        assertEquals("Ingredient number 33", entity.strIngredient14)
        assertEquals("Ingredient number 34", entity.strIngredient15)
        assertEquals("Ingredient number 35", entity.strIngredient16)
        assertEquals("Ingredient number 36", entity.strIngredient17)
        assertEquals("Ingredient number 37", entity.strIngredient18)
        assertEquals("Ingredient number 38", entity.strIngredient19)
        assertEquals("Ingredient number 39", entity.strIngredient20)
        assertEquals("Ingredient number 40", entity.strIngredient2)
        assertEquals("Ingredient number 50", entity.strIngredient3)
        assertEquals("Ingredient number 60", entity.strIngredient4)
        assertEquals("Ingredient number 70", entity.strIngredient5)
        assertEquals("Ingredient number 80", entity.strIngredient6)
        assertEquals("Ingredient number 90", entity.strIngredient7)
        assertEquals("Ingredient number 92", entity.strIngredient8)
        assertEquals("Ingredient number 94", entity.strIngredient9)
        assertEquals("Do something with ingredients", entity.strInstructions)
        assertEquals("Meal name", entity.name)
        assertEquals("image/url", entity.imageUrl)
        assertEquals("measure of ingredient number 27", entity.strMeasure1)
        assertEquals("measure of ingredient number 29", entity.strMeasure10)
        assertEquals("measure of ingredient number 30", entity.strMeasure11)
        assertEquals("measure of ingredient number 31", entity.strMeasure12)
        assertEquals("measure of ingredient number 32", entity.strMeasure13)
        assertEquals("measure of ingredient number 33", entity.strMeasure14)
        assertEquals("measure of ingredient number 34", entity.strMeasure15)
        assertEquals("measure of ingredient number 35", entity.strMeasure16)
        assertEquals("measure of ingredient number 36", entity.strMeasure17)
        assertEquals("measure of ingredient number 37", entity.strMeasure18)
        assertEquals("measure of ingredient number 38", entity.strMeasure19)
        assertEquals("measure of ingredient number 39", entity.strMeasure20)
        assertEquals("measure of ingredient number 40", entity.strMeasure2)
        assertEquals("measure of ingredient number 50", entity.strMeasure3)
        assertEquals("measure of ingredient number 60", entity.strMeasure4)
        assertEquals("measure of ingredient number 70", entity.strMeasure5)
        assertEquals("measure of ingredient number 80", entity.strMeasure6)
        assertEquals("measure of ingredient number 90", entity.strMeasure7)
        assertEquals("measure of ingredient number 92", entity.strMeasure8)
        assertEquals("measure of ingredient number 94", entity.strMeasure9)
        assertEquals("Some source", entity.strSource)
        assertEquals("tags", entity.strTags)
        assertEquals("youtube/url", entity.strYoutube)
    }
}