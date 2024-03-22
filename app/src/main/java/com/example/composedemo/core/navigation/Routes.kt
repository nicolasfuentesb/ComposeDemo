package com.example.composedemo.core.navigation

import okhttp3.Route

sealed class Routes(val route: String) {
    object SplashScreen:Routes("SplashScreenView")
    object MainScreenView:Routes("MainScreenView")
}