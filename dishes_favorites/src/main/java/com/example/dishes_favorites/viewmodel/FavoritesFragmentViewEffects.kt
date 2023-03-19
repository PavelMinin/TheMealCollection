package com.example.dishes_favorites.viewmodel

sealed class FavoritesFragmentViewEffects {
    data class Failure(val cause: Throwable) : FavoritesFragmentViewEffects()
}