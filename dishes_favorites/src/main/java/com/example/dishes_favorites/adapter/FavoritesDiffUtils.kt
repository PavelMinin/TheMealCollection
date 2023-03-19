package com.example.dishes_favorites.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.core.data.model.MealDetails

class FavoritesDiffUtils: DiffUtil.ItemCallback<MealDetails>() {
    override fun areItemsTheSame(oldItem: MealDetails, newItem: MealDetails): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MealDetails, newItem: MealDetails): Boolean {
        return oldItem == newItem
    }
}
