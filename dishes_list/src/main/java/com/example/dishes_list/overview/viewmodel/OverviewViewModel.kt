package com.example.dishes_list.overview.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.LocalRepository
import com.example.core.data.RemoteRepository
import com.example.core.data.Result
import com.example.core.data.model.MealOverview
import com.example.core.data.model.asInternalModel
import com.example.core.db.model.asExternalModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class OverviewViewModel(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) : ViewModel() {

    val viewState: StateFlow<OverviewFragmentViewState> get() = _viewState.asStateFlow()
    val viewEffects: SharedFlow<OverviewFragmentViewEffects> get() = _viewEffects.asSharedFlow()

    private val _viewState = MutableStateFlow(OverviewFragmentViewState())
    private val _viewEffects = MutableSharedFlow<OverviewFragmentViewEffects>()

    fun requestMealList() {
        if (viewState.value.meals.isNotEmpty()) return

        viewModelScope.launch {
            when (val result = remoteRepository.getRandomMealList()) {
                is Result.Success -> handleOverview(result.value)
                is Result.Failure -> handleFailure(result.cause)
            }
        }
    }

    private fun handleOverview(meals: List<MealOverview>) {
        _viewState.value = OverviewFragmentViewState(loading = false, meals = meals)
        saveToLocalRepository(meals)
    }

    private fun saveToLocalRepository(meals: List<MealOverview>) {
        viewModelScope.launch {
            localRepository.putMealList(meals.map { it.asInternalModel() })
        }
    }

    private suspend fun handleFailure(cause: Throwable) {
        _viewEffects.emit(OverviewFragmentViewEffects.Failure(cause))
    }

    fun updateMealList() {
        _viewState.value = OverviewFragmentViewState(loading = true, meals = emptyList())
        requestMealList()
    }

    fun setLocalData() {
        viewModelScope.launch {
            when (val result = localRepository.getMealList()) {
                is Result.Success -> handleOverview(result.value.map { it.asExternalModel() })
                is Result.Failure -> handleFailure(result.cause)
            }
        }
    }
}