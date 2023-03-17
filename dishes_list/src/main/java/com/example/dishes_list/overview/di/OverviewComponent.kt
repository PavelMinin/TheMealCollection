package com.example.dishes_list.overview.di

import androidx.lifecycle.ViewModel
import com.example.core.data.LocalRepository
import com.example.core.data.RemoteRepository
import com.example.dishes_list.overview.OverviewFragment
import dagger.Component
import javax.inject.Scope
import kotlin.properties.Delegates.notNull


@[OverviewScope Component(dependencies = [OverviewDeps::class])]
interface OverviewComponent {

    fun inject(fragment: OverviewFragment)

    @Component.Builder
    interface Builder {

        fun deps(overviewDeps: OverviewDeps): Builder

        fun build(): OverviewComponent
    }
}

interface OverviewDeps {

    var remoteRepository: RemoteRepository
    var localRepository: LocalRepository
}

interface OverviewDepsProvider {

    //@get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: OverviewDeps

    companion object : OverviewDepsProvider by OverviewDepsStore
}

object OverviewDepsStore : OverviewDepsProvider {

        override var deps: OverviewDeps by notNull()
}

class OverviewComponentViewModel : ViewModel() {

    val newOverviewComponent = DaggerOverviewComponent.builder()
            .deps(OverviewDepsProvider.deps)
            .build()
}

@Scope
annotation class OverviewScope