package com.example.dishes_list.overview

sealed class OverviewFragmentViewEffects {
    data class Failure(val cause: Throwable) : OverviewFragmentViewEffects()
}