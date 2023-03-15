package com.example.core.network.di

import com.example.core.network.retrofit.LocalValues
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://www.themealdb.com/api/json/v1/"
private const val API_KEY = LocalValues.API_KEY + "/"

@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient().newBuilder()
        .addNetworkInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY

        }).addInterceptor(
            Interceptor { chain ->
                val builder = chain.request().newBuilder()
                return@Interceptor chain.proceed(builder.build())
            }
        ).build()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL + API_KEY)
        .callFactory(provideOkHttpClient())
        .addConverterFactory(provideGsonConverterFactory())
        .build()
//
//    @Binds
//    @Singleton
//    fun bindImageLoader(
//        provideOkHttpClient: OkHttpClient,
//        context: Context
//    ): ImageLoader = ImageLoader.Builder(context)
//        .callFactory(provideOkHttpClient)
//        .build()
}

//fun main() {
//    GlobalScope.launch {
//        val retrofit = NetworkModule.provideRetrofit().create<NetworkApi>()
//        val areas = retrofit.getListOfAllAreas().meals
//        println(areas)
//        val categories = retrofit.getListOfAllCategories().categories
//        println(categories)
//        val randomMeal = retrofit.getRandomMeal().meals[0]
//        println(randomMeal)
//        val mealDetails = retrofit.getMealDetails(randomMeal.id).meals[0]
//        println(mealDetails)
//        val ingredients = retrofit.getListOfAllIngredients()
//        println(ingredients)
//        val findByName = retrofit.getMealByName("br")
//        println(findByName)
//        val findByCategory = retrofit.getMealsByCategory("Seafood")
//        println(findByCategory)
//        val findByArea = retrofit.getMealsByArea("Canadian")
//        println(findByArea)
//    }
//    Thread.sleep(1000)
//}