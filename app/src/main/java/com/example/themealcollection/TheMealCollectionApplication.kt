package com.example.themealcollection

import android.app.Application
import com.example.dish_details.di.DetailsDepsStore
import com.example.dishes_favorites.di.FavoritesDepsStore
import com.example.dishes_list.overview.di.OverviewDepsStore
import com.example.themealcollection.LocalValues.API_KEY
import com.example.themealcollection.di.AppComponent
import com.example.themealcollection.di.DaggerAppComponent

class TheMealCollectionApplication : Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .context(this)
            .apiKey(API_KEY)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        OverviewDepsStore.deps = appComponent
        DetailsDepsStore.deps = appComponent
        FavoritesDepsStore.deps = appComponent
    }
}