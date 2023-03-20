package com.example.search.viewmodel

sealed class SearchFragmentViewEffects {

    data class Failure(val cause: Throwable) : SearchFragmentViewEffects()
}