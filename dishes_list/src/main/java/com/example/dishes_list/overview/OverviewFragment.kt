package com.example.dishes_list.overview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core.data.model.mealList
import com.example.core.utils.viewBinding
import com.example.dishes_list.R
import com.example.dishes_list.databinding.FragmentOverviewBinding
import com.example.navigation.BaseFragment


class OverviewFragment : BaseFragment(R.layout.fragment_overview) {

    private val binding by viewBinding(FragmentOverviewBinding::bind)
    private val viewModel: OverviewViewModel by viewModels()

    private val adapter = MealAdapter(mealList) { meal ->
        findNavController().navigate(
            OverviewFragmentDirections.actionFragmentOverviewPageToNavUserDetails(meal)
        )
            findNavController()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        requestData()

//        val linearLayoutManager = LinearLayoutManager(
//            view.context, LinearLayoutManager.VERTICAL, false
//        )
//
//        with(binding) {
//            recyclerView.adapter = adapter
//            recyclerView.layoutManager = linearLayoutManager
//            recyclerView.addHorizontalSpaceDecoration(RECYCLER_ITEM_SPACE)
//        }
    }

    private fun setupUI() {
        val adapter = createAdapter()
    }

    private fun createAdapter(): MealAdapter {
        return MealAdapter { coinId, name -> navigateToHistory(coinId, name) }
    }
}

