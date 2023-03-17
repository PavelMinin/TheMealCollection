package com.example.dish_details.di

import androidx.lifecycle.ViewModel
import com.example.core.data.LocalRepository
import com.example.core.data.RemoteRepository
import com.example.dish_details.DetailsFragment
import dagger.Component
import javax.inject.Scope
import kotlin.properties.Delegates.notNull


@[DetailsScope Component(dependencies = [DetailsDeps::class])]
interface DetailsComponent {

    fun inject(fragment: DetailsFragment)

    @Component.Builder
    interface Builder {

        fun deps(deps: DetailsDeps): Builder

        fun build(): DetailsComponent
    }
}

interface DetailsDeps {

    var remoteRepository: RemoteRepository
    var localRepository: LocalRepository
}

interface DetailsDepsProvider {

    //@get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: DetailsDeps

    companion object : DetailsDepsProvider by DetailsDepsStore
}

object DetailsDepsStore : DetailsDepsProvider {

        override var deps: DetailsDeps by notNull()
}

class DetailsComponentViewModel : ViewModel() {

    val newDetailsComponent = DaggerDetailsComponent.builder()
            .deps(DetailsDepsProvider.deps)
            .build()
}

@Scope
annotation class DetailsScope