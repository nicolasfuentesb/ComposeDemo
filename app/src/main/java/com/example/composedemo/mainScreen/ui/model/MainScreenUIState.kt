package com.example.composedemo.mainScreen.ui.model

sealed interface MainScreenUIState {
    object Loading: MainScreenUIState
    data class  Error(val throwable: Throwable): MainScreenUIState
    data class Success(val config:List<MainScreenModel>): MainScreenUIState
}