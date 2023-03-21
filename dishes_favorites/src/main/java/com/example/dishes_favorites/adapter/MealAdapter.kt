package com.example.dishes_favorites.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.core.data.model.MealDetails
import com.example.dishes_favorites.databinding.ItemViewBinding

class MealAdapter(
    private val onItemClick: (String) -> Unit
) : ListAdapter<MealDetails, MealFavoritesViewHolder>(FavoritesDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealFavoritesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MealFavoritesViewHolder(
            binding = ItemViewBinding.inflate(layoutInflater, parent, false),
            onItemClick = onItemClick
        )
    }

    override fun onBindViewHolder(holder: MealFavoritesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}