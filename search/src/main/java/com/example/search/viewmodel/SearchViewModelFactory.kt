package com.example.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.data.RemoteRepository
import javax.inject.Inject
import javax.inject.Provider


class SearchViewModelFactory @Inject constructor(
    private val remoteRepository: Provider<RemoteRepository>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == SearchViewModel::class.java)
        return SearchViewModel(
            remoteRepository.get()
        ) as T
    }
}