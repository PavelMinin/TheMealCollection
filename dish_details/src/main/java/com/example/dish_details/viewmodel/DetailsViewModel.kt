package com.example.dish_details.viewmodel

import android.util.Log
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
        try {

        } catch (e: Throwable) {
            Log.i(TAG_LOCAL_DATA, "Error: $e")
        }

        viewModelScope.launch {
            when (val result = localRepository.getMealDetails(id)) {
                is Result.Success -> {
                    Log.i(TAG_LOCAL_DATA, "Received data: ${result.value?.id}")
                    if (result.value != null) {
                        handleFavoritesDetails(result.value!!.asExternalModel())
                    } else {
                        when (val resultRemote = remoteRepository.getMealDetails(id)) {
                            is Result.Success -> handleDetails(resultRemote.value)
                            is Result.Failure -> handleFailure(resultRemote.cause)
                        }
                    }
                }
                is Result.Failure -> {
                    handleFailure(result.cause)
                    Log.i(TAG_LOCAL_DATA, "Failure cause: ${result.cause}")
                }
            }
        }
    }

    private fun handleDetails(mealDetails: MealDetails) {
        _viewState.value = DetailsFragmentViewState(
            loading = false,
            mealDetails = mealDetails,
            isFavorites = false
        )
        Log.i(TAG_LOCAL_DATA, "Success: $mealDetails")
    }

    private fun handleFavoritesDetails(mealDetails: MealDetails) {
        _viewState.value = DetailsFragmentViewState(
            loading = false,
            mealDetails = mealDetails,
            isFavorites = true
        )
        Log.i(TAG_LOCAL_DATA, "Success: $mealDetails")
    }

    fun pressOnFavoritesButton() {
        if (viewState.value.isFavorites) deleteFromFavorites()
        else addToFavorites()
    }

    private fun addToFavorites() {
        try {
            viewModelScope.launch {
                val details = viewState.value.mealDetails
                details?.asInternalModel()?.let { it -> localRepository.putMealFavorites(it) }
                handleFavoritesDetails(requireNotNull(details))
            }
        } catch (e: Throwable) {
            viewModelScope.launch { handleFailure(e) }
        }
    }

    private fun deleteFromFavorites() {
        try {
            viewModelScope.launch {
                val details = viewState.value.mealDetails
                details?.asInternalModel()?.let { it ->
                    localRepository.deleteMealFromFavorites(it)
                }
                handleDetails(requireNotNull(details))
            }
        } catch (e: Throwable) {
            viewModelScope.launch { handleFailure(e) }
        }
    }

    private suspend fun handleFailure(cause: Throwable) {
        _viewEffects.emit(DetailsFragmentViewEffects.Failure(cause))
        Log.i(TAG_LOCAL_DATA, "Failure: $cause")
    }

    fun setLocalData(id: String) {
        requestMealDetails(id)
    }

    companion object Tags {
        const val TAG_LOCAL_DATA = "TAG_LOCAL_DATA"
    }
}