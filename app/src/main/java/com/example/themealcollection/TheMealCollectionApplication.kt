package com.example.themealcollection

import android.app.Application

class TheMealCollectionApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .context(context = this)
            .build()
    }
}