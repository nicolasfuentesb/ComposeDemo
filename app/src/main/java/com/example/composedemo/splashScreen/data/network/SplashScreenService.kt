package com.example.composedemo.splashScreen.data.network

import com.example.composedemo.splashScreen.data.network.response.SplashScreenResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class SplashScreenService @Inject constructor(private val splashScreenClient: SplashScreenClient) {

    suspend fun doGetConfig():Response<SplashScreenResponse>{

        val response: Response<SplashScreenResponse>
        withContext(Dispatchers.IO){
            response = splashScreenClient.doGetConfig()
        }
        return response
    }
}