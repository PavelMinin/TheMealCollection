package com.example.search.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.size.ViewSizeResolver
import com.example.core.data.model.MealOverview
import com.example.search.databinding.ItemViewBinding

class MealOverviewViewHolder(
    private val binding: ItemViewBinding,
    private val onItemClick: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MealOverview) {
        with(binding) {
            image.load(item.imageUrl + "/preview") {
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