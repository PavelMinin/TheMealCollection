package com.example.dishes_favorites.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.data.LocalRepository
import javax.inject.Inject
import javax.inject.Provider


class FavoritesViewModelFactory @Inject constructor(
    private val localRepository: Provider<LocalRepository>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == FavoritesViewModel::class.java)
        return FavoritesViewModel(
            localRepository.get()
        ) as T
    }
}