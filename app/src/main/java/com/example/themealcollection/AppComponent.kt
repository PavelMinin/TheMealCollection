package com.example.themealcollection

import android.content.Context
import com.example.core.db.di.DaosModule
import com.example.core.db.di.DatabaseModule
import com.example.core.network.di.NetworkModule
import dagger.BindsInstance
import dagger.Component

@Component(modules = [
    NetworkModule::class,
    DaosModule::class,
    DatabaseModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}