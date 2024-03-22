package com.example.composedemo.mainScreen.domain

import com.example.composedemo.mainScreen.data.MainScreenOptionsRepo
import com.example.composedemo.mainScreen.ui.model.MainScreenOptions
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOptionsUseCase  @Inject constructor(private val mainScreenOptionsRepo: MainScreenOptionsRepo) {
    operator fun invoke(): Flow<List<MainScreenOptions>> = mainScreenOptionsRepo.getOptions
}