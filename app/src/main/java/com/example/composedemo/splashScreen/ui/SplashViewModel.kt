package com.example.composedemo.splashScreen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.composedemo.core.navigation.Routes
import com.example.composedemo.mainScreen.domain.AddConfigUseCase
import com.example.composedemo.mainScreen.domain.AddOptionsUseCase
import com.example.composedemo.mainScreen.ui.model.MainScreenModel
import com.example.composedemo.mainScreen.ui.model.MainScreenOptions
import com.example.composedemo.splashScreen.data.network.SplashScreenService
import com.example.composedemo.splashScreen.data.network.response.SplashScreenResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val splashScreenService: SplashScreenService,
                                          private val addConfigUseCase: AddConfigUseCase,
                                          private val addOptionsUseCase: AddOptionsUseCase): ViewModel() {

    fun startApp(navHostController: NavHostController) {
        viewModelScope.launch {

            val response: Response<SplashScreenResponse> = splashScreenService.doGetConfig()

            val mainScreenModel =
                response.body()?.let { MainScreenModel( it.id,
                    it.background_color,
                    it.drawer_background_color,
                    it.drawer_text_color,
                    it.top_bar_background_color,
                    it.top_bar_scroll_color,
                    it.button_color,
                    it.button_icon_color
                )}

            val mainScreenOptions =
                response.body()?.let { MainScreenOptions(
                    it.menu_options[0],
                    it.menu_options[1],
                    it.menu_options[2],
                    it.menu_options[3]
                )}

            if (mainScreenModel != null) {
                addConfigUseCase(MainScreenModel(mainScreenModel.id,
                    mainScreenModel.background_color,
                    mainScreenModel.drawer_background_color,
                    mainScreenModel.drawer_text_color,
                    mainScreenModel.top_bar_background_color,
                    mainScreenModel.top_bar_scroll_color,
                    mainScreenModel.button_color,
                    mainScreenModel.button_icon_color
                ))
            }

            if (mainScreenOptions != null){
                addOptionsUseCase(MainScreenOptions(
                    mainScreenOptions.option1,
                    mainScreenOptions.option2,
                    mainScreenOptions.option3,
                    mainScreenOptions.option4
                ))
            }
            nextScreen(navHostController)
        }
    }

    private fun nextScreen(navHostController: NavHostController){
        navHostController.navigate(Routes.MainScreenView.route)
    }
}