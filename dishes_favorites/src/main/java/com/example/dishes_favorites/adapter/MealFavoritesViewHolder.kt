package com.example.dishes_favorites.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.size.ViewSizeResolver
import com.example.core.data.model.MealDetails
import com.example.dishes_favorites.databinding.ItemViewBinding

class MealFavoritesViewHolder(
    private val binding: ItemViewBinding,
    private val onItemClick: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MealDetails) {
        with(binding) {
            image.load(item.imageUrl) {
                scale(Scale.FIT)
                size(ViewSizeResolver(root))
            }
            textName.text = item.name
            textAreaValue.text = item.area
            textCategoryValue.text = item.category

            root.setOnClickListener {
                onItemClick(item.id)
            }
        }
    }
}