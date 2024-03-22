package com.example.composedemo.core.di

import com.example.composedemo.splashScreen.data.network.SplashScreenClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }

    @Singleton
    @Provides
    fun provideSplashClient(retrofit: Retrofit):SplashScreenClient{
        return retrofit.create(SplashScreenClient::class.java)
    }
}