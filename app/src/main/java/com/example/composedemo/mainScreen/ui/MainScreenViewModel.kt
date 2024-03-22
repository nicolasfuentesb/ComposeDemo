package com.example.composedemo.mainScreen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composedemo.mainScreen.domain.GetConfigUseCase
import com.example.composedemo.mainScreen.domain.GetOptionsUseCase
import com.example.composedemo.mainScreen.ui.model.MainScreenUIState
import com.example.composedemo.mainScreen.ui.model.MainScreenUIState.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    getConfigUseCase: GetConfigUseCase,
    getOptionsUseCase: GetOptionsUseCase): ViewModel() {

     val uiState: StateFlow<MainScreenUIState> = getConfigUseCase().map(::Success)
        .catch { MainScreenUIState.Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), MainScreenUIState.Loading)
}
