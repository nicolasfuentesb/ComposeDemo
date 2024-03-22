package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.composedemo.core.navigation.Navigation
import com.example.composedemo.mainScreen.domain.GetConfigUseCase
import com.example.composedemo.mainScreen.ui.MainScreenViewModel
import com.example.composedemo.splashScreen.ui.SplashViewModel
import com.example.composedemo.ui.theme.ComposeDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val splashViewModel: SplashViewModel by viewModels()
    private val mainScreenViewModel: MainScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeDemoTheme {
                Navigation(splashViewModel, mainScreenViewModel)
            }
        }
    }
}


