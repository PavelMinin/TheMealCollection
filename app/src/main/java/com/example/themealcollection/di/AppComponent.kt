package com.example.themealcollection.di

import android.app.Application
import android.content.Context
import com.example.core.data.LocalRepository
import com.example.core.data.LocalRepositoryImpl
import com.example.core.data.RemoteRepository
import com.example.core.data.RemoteRepositoryImpl
import com.example.dish_details.di.DetailsDeps
import com.example.dishes_favorites.di.FavoritesDeps
import com.example.dishes_list.overview.di.OverviewDeps
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Scope
import javax.inject.Singleton

@[Singleton Component(modules = [AppModule::class])]
interface AppComponent : OverviewDeps, DetailsDeps, FavoritesDeps {

    override var remoteRepository: RemoteRepository
    override var localRepository: LocalRepository

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context(context: Context): Builder

        @BindsInstance
        fun apiKey(@ApiQualifier apiKey: String): Builder

        fun build(): AppComponent
    }
}

@Module
class AppModule {

    @[Provides AppScope]
    fun provideRemoteRepository(@ApiQualifier apiKey: String) : RemoteRepository {
        return RemoteRepositoryImpl(apiKey)
    }

    @[Provides AppScope]
    fun provideLocalRepository(context: Context) : LocalRepository {
        return LocalRepositoryImpl(context)
    }
}

@Qualifier
annotation class ApiQualifier

@Scope
annotation class AppScope