package com.example.themealcollection.fragments

import android.os.Bundle
import android.view.View
import com.example.core.utils.viewBinding
import com.example.navigation.TabNavigationFragment
import com.example.themealcollection.R
import com.example.themealcollection.databinding.FragmentContentBinding

class ContentFragment : TabNavigationFragment(R.layout.fragment_content) {

    private val binding by viewBinding(FragmentContentBinding::bind)

    override val containerId: Int = R.id.content_container
    override val tabs by lazy {
        listOf(
            Tab(getString(R.string.overview_page),
                com.example.dishes_list.R.navigation.nav_list_flow),
            Tab(getString(R.string.advanced_search_page),
                com.example.search.R.navigation.nav_search),
            Tab(getString(R.string.favorites_page),
                com.example.dishes_favorites.R.navigation.nav_favorites)
        )
    }
    private lateinit var selectedTab: Tab

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(!needShowBottomBar) {
            binding.bottomNavBar.setWillNotDraw(true)
            binding.bottomNavBar.invalidate()
        }


        selectedTab = tabs[0]
        selectTab(tabs[0])

        binding.bottomNavBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.fragment_overview_page -> {
                    if (selectedTab.name != tabs[0].name) selectTab(tabs[0])
                    true
                }
                R.id.fragment_search_page -> {
                    if (selectedTab.name != tabs[1].name) selectTab(tabs[1])
                    true
                }
                R.id.fragment_favorites_page -> {
                    if (selectedTab.name != tabs[2].name) selectTab(tabs[2])
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun tabSelected(tab: Tab) {
        selectedTab = tab
    }
}