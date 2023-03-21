package com.example.dishes_list.overview.viewmodel

sealed class OverviewFragmentViewEffects {
    data class Failure(val cause: Throwable) : OverviewFragmentViewEffects()
}