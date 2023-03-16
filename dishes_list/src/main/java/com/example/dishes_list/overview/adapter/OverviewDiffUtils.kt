package com.example.dishes_list.overview.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.core.data.model.MealOverview

class OverviewDiffUtils: DiffUtil.ItemCallback<MealOverview>() {
    override fun areItemsTheSame(oldItem: MealOverview, newItem: MealOverview): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MealOverview, newItem: MealOverview): Boolean {
        return oldItem == newItem
    }
}
