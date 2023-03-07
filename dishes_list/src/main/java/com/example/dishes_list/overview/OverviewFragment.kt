package com.example.dishes_list.overview

import android.os.Bundle
import android.view.View
import com.example.core.viewBinding
import com.example.dishes_list.R
import com.example.dishes_list.databinding.FragmentOverviewBinding
import com.example.navigation.BaseFragment


class OverviewFragment : BaseFragment(R.layout.fragment_overview) {

    private val binding by viewBinding(FragmentOverviewBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView
    }
}