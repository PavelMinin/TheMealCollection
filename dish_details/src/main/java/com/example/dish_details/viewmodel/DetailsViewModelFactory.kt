package com.example.dish_details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.data.LocalRepository
import com.example.core.data.RemoteRepository
import javax.inject.Inject
import javax.inject.Provider


class DetailsViewModelFactory @Inject constructor(
    private val remoteRepository: Provider<RemoteRepository>,
    private val localRepository: Provider<LocalRepository>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == DetailsViewModel::class.java)
        return DetailsViewModel(
            remoteRepository.get(),
            localRepository.get()
        ) as T
    }
}