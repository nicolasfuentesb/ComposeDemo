package com.example.composedemo.splashScreen.data.network

import com.example.composedemo.splashScreen.data.network.response.SplashScreenResponse
import retrofit2.Response
import retrofit2.http.GET

interface SplashScreenClient {

    @GET("3f29c1fb-69be-4731-80b1-ace1fd97e009")
    suspend fun doGetConfig():Response<SplashScreenResponse>
}