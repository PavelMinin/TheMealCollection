package com.example.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.RemoteRepository
import com.example.core.data.Result
import com.example.core.data.model.MealOverview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SearchViewModel(
    private val remoteRepository: RemoteRepository
) : ViewModel() {

    val viewState: StateFlow<SearchFragmentViewState> get() = _viewState.asStateFlow()
    val viewEffects: SharedFlow<SearchFragmentViewEffects> get() = _viewEffects.asSharedFlow()

    private val _viewState = MutableStateFlow(SearchFragmentViewState())
    private val _viewEffects = MutableSharedFlow<SearchFragmentViewEffects>()

    fun searchRequest(name: String) {
        viewModelScope.launch {
            when (val result = remoteRepository.findMealByName(name)) {
                is Result.Success -> handleSearch(result.value)
                is Result.Failure -> handleFailure(result.cause)
            }
        }
    }

    private fun handleSearch(meals: List<MealOverview>) {
        if(meals == null) {
            _viewState.value = SearchFragmentViewState(loading = false, meals = emptyList())
        } else {
            _viewState.value = SearchFragmentViewState(loading = false, meals = meals)
        }
    }


    private suspend fun handleFailure(cause: Throwable) {
        _viewEffects.emit(SearchFragmentViewEffects.Failure(cause))
    }
}