package com.example.dishes_list.overview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.size.ViewSizeResolver
import com.example.core.data.model.MealOverview
import com.example.dish_details.databinding.ItemViewBinding

class MealAdapter(
    private val data: ArrayList<MealOverview>,
    private val onItemClick: (MealOverview) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class MealOverviewViewHolder(
        private val binding: ItemViewBinding,
        private val onItemClick: (MealOverview) -> Unit
        ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MealOverview) {
            with(binding) {
                image.load(item.imageUrl) {
                    scale(Scale.FIT)
                    size(ViewSizeResolver(root))
                }
                textName.text = item.name

                root.setOnClickListener {
                    onItemClick(item)
                }
            }
        }
    }

    override fun getItemCount(): Int = data.size
}