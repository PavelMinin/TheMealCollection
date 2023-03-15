package com.example.dishes_favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.size.ViewSizeResolver
import com.example.core.data.model.MealOverview
import com.example.dishes_favorites.databinding.ItemViewBinding

class MealAdapter(
    private val data: List<MealOverview>,
    private val onItemClick: (MealOverview) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MealOverviewViewHolder(
            binding = ItemViewBinding.inflate(layoutInflater, parent, false),
            onItemClick = onItemClick
        )
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MealOverviewViewHolder).bind(data[position])
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
                textAreaValue.text = item.area
                textCategoryValue.text = item.category

                root.setOnClickListener {
                    onItemClick(item)
                }
            }
        }
    }

    override fun getItemCount(): Int = data.size
}