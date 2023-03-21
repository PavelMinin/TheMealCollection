package com.example.core.data.db.model

import com.example.core.db.model.MealOverviewEntity
import com.example.core.db.model.asExternalModel
import junit.framework.TestCase.assertEquals
import org.junit.Test

class MealOverviewEntityTest {

    @Test
    fun meal_overview_can_be_mapped_to_meal_details_entity() {
        val networkModel = MealOverviewEntity(
            id = "5565",
            area = "Canada",
            category = "Beef",
            name = "Meal name",
            imageUrl = "image/url"
        )
        
        val entity = networkModel.asExternalModel()

        assertEquals("5565", entity.id)
        assertEquals("Canada", entity.area)
        assertEquals("Beef", entity.category)
        assertEquals("Meal name", entity.name)
        assertEquals("image/url", entity.imageUrl)
    }
}