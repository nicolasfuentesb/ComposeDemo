package com.example.composedemo.mainScreen.domain

import com.example.composedemo.mainScreen.data.MainScreenRepo
import com.example.composedemo.mainScreen.ui.model.MainScreenModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetConfigUseCase @Inject constructor(private val mainScreenRepo: MainScreenRepo) {
    operator fun invoke():Flow<List<MainScreenModel>> = mainScreenRepo.getConfig
}