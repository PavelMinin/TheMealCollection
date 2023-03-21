package com.example.dishes_favorites.di

import androidx.lifecycle.ViewModel
import com.example.core.data.LocalRepository
import com.example.dishes_favorites.FavoritesFragment
import dagger.Component
import javax.inject.Scope
import kotlin.properties.Delegates.notNull

@[FavoritesScope Component(dependencies = [FavoritesDeps::class])]
interface FavoritesComponent {

    fun inject(fragment: FavoritesFragment)

    @Component.Builder
    interface Builder {

        fun deps(favoritesDeps: FavoritesDeps): Builder

        fun build(): FavoritesComponent
    }
}

interface FavoritesDeps {

    var localRepository: LocalRepository
}

interface FavoritesDepsProvider {

    //@get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: FavoritesDeps

    companion object : FavoritesDepsProvider by FavoritesDepsStore
}

object FavoritesDepsStore : FavoritesDepsProvider {

        override var deps: FavoritesDeps by notNull()
}

class FavoritesComponentViewModel : ViewModel() {

    val newFavoritesComponent = DaggerFavoritesComponent.builder()
            .deps(FavoritesDepsProvider.deps)
            .build()
}

@Scope
annotation class FavoritesScope