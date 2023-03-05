package com.example.core.data.repository.retrofit

import LocalValues.API_KEY
import com.example.core.data.repository.di.DaggerNetworkComponent
import javax.inject.Inject
import javax.inject.Singleton

// API from TheMealDB https://www.themealdb.com/api.php
private const val BASE_URL = "www.themealdb.com/api/json/v1"

private const val HEADER_API_KEY = "X-RapidAPI-Key"
private const val API_KEY = API_KEY

private const val HEADER_HOST = "X-RapidAPI-Host"
private const val HOST_VALUE = "themealdb.p.rapidapi.com"

@Singleton
private val networkComponent = DaggerNetworkComponent.builder().build()

private interface RetrofitTmcNetworkApi {
}

class RetrofitTmcNetwork @Inject constructor(
)