package com.example.composedemo.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composedemo.mainScreen.ui.MainScreenView
import com.example.composedemo.mainScreen.ui.MainScreenViewModel
import com.example.composedemo.splashScreen.ui.SplashScreenView
import com.example.composedemo.splashScreen.ui.SplashViewModel

@Composable
fun Navigation(splashViewModel: SplashViewModel,
               mainScreenViewModel: MainScreenViewModel){
    val navigationController = rememberNavController()
    NavHost(navController = navigationController,
        startDestination = Routes.SplashScreen.route){
        composable(Routes.SplashScreen.route){ SplashScreenView(splashViewModel, navigationController) }
        composable(Routes.MainScreenView.route){ MainScreenView(mainScreenViewModel, navigationController) }
    }
}