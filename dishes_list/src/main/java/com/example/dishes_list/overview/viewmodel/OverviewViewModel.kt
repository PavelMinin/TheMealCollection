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
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class OverviewViewModel(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) : ViewModel() {

    val viewState: StateFlow<OverviewFragmentViewState> get() = _viewState.asStateFlow()
    val viewEffects: SharedFlow<OverviewFragmentViewEffects> get() = _viewEffects.asSharedFlow()
    private val mutex = Mutex()

    private val _viewState = MutableStateFlow(OverviewFragmentViewState())
    private val _viewEffects = MutableSharedFlow<OverviewFragmentViewEffects>()

    private fun requestMealListFromServer() {
        viewModelScope.launch {
            mutex.withLock {
                when (val result = remoteRepository.getRandomMealList()) {
                    is Result.Success -> handleServer(result.value)
                    is Result.Failure -> handleFailure(result.cause)
                }
                requestMealListFromDb()
            }

        }
    }

    fun requestMealListFromDb() {
        viewModelScope.launch {
            when (val result = localRepository.getMealList()) {
                is Result.Success -> handleLocal(result.value.map { it.asExternalModel() })
                is Result.Failure -> handleFailure(result.cause)
            }
        }
    }

    private fun handleServer(meals: List<MealOverview>) {
        saveToLocalRepository(meals)
    }

    private fun handleLocal(meals: List<MealOverview>) {
        if(meals.isEmpty()) {
            requestMealListFromServer()
            return
        }
        _viewState.value = OverviewFragmentViewState(loading = false, meals = meals)
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
        requestMealListFromServer()
        _viewState.value = OverviewFragmentViewState(loading = true, meals = viewState.value.meals)
    }

    fun setLocalData() {
       requestMealListFromDb()
    }
}