package com.example.dish_details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.LocalRepository
import com.example.core.data.RemoteRepository
import com.example.core.data.Result
import com.example.core.data.model.MealDetails
import com.example.core.data.model.asInternalModel
import com.example.core.db.model.asExternalModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) : ViewModel() {

    val viewState: StateFlow<DetailsFragmentViewState> get() = _viewState.asStateFlow()
    val viewEffects: SharedFlow<DetailsFragmentViewEffects> get() = _viewEffects.asSharedFlow()

    private val _viewState = MutableStateFlow(DetailsFragmentViewState())
    private val _viewEffects = MutableSharedFlow<DetailsFragmentViewEffects>()

    fun requestMealDetails(id: String) {
        if (viewState.value.mealDetails != null) return

        viewModelScope.launch {
            when (val result = remoteRepository.getMealDetails(id)) {
                is Result.Success -> handleDetails(result.value)
                is Result.Failure -> handleFailure(result.cause)
            }
        }
    }

    private fun handleDetails(mealDetails: MealDetails) {
        _viewState.value = DetailsFragmentViewState(loading = false, mealDetails = mealDetails)
    }

    private fun addToFavorites(mealDetails: MealDetails) {
        viewModelScope.launch {
            localRepository.putMealFavorites(mealDetails.asInternalModel())
        }
    }

    private suspend fun handleFailure(cause: Throwable) {
        _viewEffects.emit(DetailsFragmentViewEffects.Failure(cause))
    }

    fun updateMealDetails(id: String) {
        _viewState.value = DetailsFragmentViewState(loading = true, mealDetails = null)
        requestMealDetails(id)
    }

    fun setLocalData(id: String) {
        viewModelScope.launch {
            when (val result = localRepository.getMealDetails(id)) {
                is Result.Success -> handleDetails(result.value.asExternalModel())
                is Result.Failure -> handleFailure(result.cause)
            }
        }
    }
}