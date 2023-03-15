package com.example.dishes_favorites

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.data.model.mealList
import com.example.core.utils.Utils.RECYCLER_ITEM_SPACE
import com.example.core.utils.Utils.addHorizontalSpaceDecoration
import com.example.core.utils.viewBinding
import com.example.dishes_favorites.databinding.FragmentFavoritesBinding
import com.example.navigation.BaseFragment

class FavoritesFragment : BaseFragment(R.layout.fragment_favorites) {

    private val binding by viewBinding(FragmentFavoritesBinding::bind)

    private val adapter = MealAdapter(mealList) { meal ->
        findNavController().navigate(
            FavoritesFragmentDirections.actionFragmentFavoritesPageToNavUserDetails(meal)
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val linearLayoutManager = LinearLayoutManager(
            view.context, LinearLayoutManager.VERTICAL, false
        )

        with(binding) {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = linearLayoutManager
            recyclerView.addHorizontalSpaceDecoration(RECYCLER_ITEM_SPACE)
        }
    }
}