package com.example.core.data.repository.di

import android.content.Context
import coil.ImageLoader
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideGsonConverterFactory() = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient().newBuilder()
        .addNetworkInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()

    @Provides
    fun bindImageLoader(
        provideOkHttpClient: OkHttpClient,
        context: Context
    ): ImageLoader = ImageLoader.Builder(context)
        .callFactory(provideOkHttpClient)
        .build()
}