package com.example.dishes_list.overview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.core.data.model.MealOverview
import com.example.dishes_list.databinding.ItemViewBinding

class MealAdapter(
    //private val data: List<MealOverview>,
    private val onItemClick: (MealOverview) -> Unit
) : ListAdapter<MealOverview, MealOverviewViewHolder>(OverviewDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealOverviewViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MealOverviewViewHolder(
            binding = ItemViewBinding.inflate(layoutInflater, parent, false),
            onItemClick = onItemClick
        )
    }

    override fun onBindViewHolder(holder: MealOverviewViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    //override fun getItemCount(): Int = data.size
}