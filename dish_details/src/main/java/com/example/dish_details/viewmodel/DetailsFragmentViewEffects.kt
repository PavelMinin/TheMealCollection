package com.example.dish_details.viewmodel

sealed class DetailsFragmentViewEffects {
    data class Failure(val cause: Throwable) : DetailsFragmentViewEffects()
}