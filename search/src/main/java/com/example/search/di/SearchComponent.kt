package com.example.search.di

import androidx.lifecycle.ViewModel
import com.example.core.data.RemoteRepository
import com.example.search.FragmentSearch
import dagger.Component
import javax.inject.Scope
import kotlin.properties.Delegates.notNull


@[SearchScope Component(dependencies = [SearchDeps::class])]
interface SearchComponent {

    fun inject(fragment: FragmentSearch)

    @Component.Builder
    interface Builder {

        fun deps(searchDeps: SearchDeps): Builder

        fun build(): SearchComponent
    }
}

interface SearchDeps {

    var remoteRepository: RemoteRepository
}

interface SearchDepsProvider {

    //@get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: SearchDeps

    companion object : SearchDepsProvider by SearchDepsStore
}

object SearchDepsStore : SearchDepsProvider {

        override var deps: SearchDeps by notNull()
}

class SearchComponentViewModel : ViewModel() {

    val searchComponent = DaggerSearchComponent.builder()
        .deps(SearchDepsProvider.deps)
        .build()
}

@Scope
annotation class SearchScope