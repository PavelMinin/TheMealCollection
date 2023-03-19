package com.example.core.network.retrofit

import com.example.core.data.model.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL = "https://www.themealdb.com/api/json/v1"
interface ApiService {
    @GET(value = "random.php")
    suspend fun getRandomMeal() : MealWrapper

    @GET(value = "lookup.php")
    suspend fun getMealDetails(
        @Query("i") id: String
    ) : MealDetailsWrapper

    @GET(value = "list.php?i=list")
    suspend fun getListOfAllIngredients() : IngredientsWrapper

    @GET(value = "list.php?a=list")
    suspend fun getListOfAllAreas() : AreasWrapper

    @GET(value = "categories.php")
    suspend fun getListOfAllCategories() : CategoriesWrapper

    @GET(value = "search.php")
    suspend fun getMealByName(
        @Query("s") name: String
    ) : MealWrapper

    @GET(value = "filter.php")
    suspend fun getMealsByCategory(
        @Query("c") category: String
    ) : MealWrapper

    @GET(value = "filter.php")
    suspend fun getMealsByArea(
        @Query("a") area: String
    ) : MealWrapper
}

fun ApiService(apiKey: String): ApiService {

    val okHttpClient = OkHttpClient().newBuilder()
        .addNetworkInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY

        }).addInterceptor(
            Interceptor { chain ->
                val builder = chain.request().newBuilder()
                return@Interceptor chain.proceed(builder.build())
            }
        ).build()

    val gsonConverterFactory: GsonConverterFactory = GsonConverterFactory.create()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL + apiKey)
        .callFactory(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()

    return retrofit.create(ApiService::class.java)
}

