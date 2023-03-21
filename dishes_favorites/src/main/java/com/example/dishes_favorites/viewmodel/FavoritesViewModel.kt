package com.example.dishes_favorites.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.LocalRepository
import com.example.core.data.Result
import com.example.core.data.model.MealDetails
import com.example.core.db.model.asExternalModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val localRepository: LocalRepository
) : ViewModel() {

    val viewState: StateFlow<FavoritesFragmentViewState> get() = _viewState.asStateFlow()
    val viewEffects: SharedFlow<FavoritesFragmentViewEffects> get() = _viewEffects.asSharedFlow()

    private val _viewState = MutableStateFlow(FavoritesFragmentViewState())
    private val _viewEffects = MutableSharedFlow<FavoritesFragmentViewEffects>()

    fun requestFavoritesList() {
        viewModelScope.launch {
            when (val result = localRepository.getMealFavorites()) {
                is Result.Success -> handleFavorites(result.value.map { it.asExternalModel() })
                is Result.Failure -> handleFailure(result.cause)
            }
        }
    }

    private fun handleFavorites(meals: List<MealDetails>) {
        _viewState.value = FavoritesFragmentViewState(loading = false, meals = meals)
    }

    private suspend fun handleFailure(cause: Throwable) {
        _viewEffects.emit(FavoritesFragmentViewEffects.Failure(cause))
    }
}