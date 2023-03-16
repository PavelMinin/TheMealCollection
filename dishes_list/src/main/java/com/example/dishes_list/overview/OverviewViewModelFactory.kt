package com.example.dishes_list.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.data.LocalRepository
import com.example.core.data.RemoteRepository
import javax.inject.Inject
import javax.inject.Provider


class OverviewViewModelFactory @Inject constructor(
    private val remoteRepository: Provider<RemoteRepository>,
    private val localRepository: Provider<LocalRepository>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == OverviewViewModel::class.java)
        return OverviewViewModel(
            remoteRepository.get(),
            localRepository.get()
        ) as T
    }
}