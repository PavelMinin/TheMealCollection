package com.example.themealcollection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Scope

@Component(modules = [AppModule::class])
interface AppComponent : ArticlesDeps {
    override val networkService: NetworkService

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun apiKey(@NetworkApiQualifier apiKey: String): Builder

        fun build(): AppComponent
    }
}

@Qualifier
annotation class NeApiQualifier

@Scope
annotation class AppScope