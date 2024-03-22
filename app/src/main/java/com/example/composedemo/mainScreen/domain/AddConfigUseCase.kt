package com.example.composedemo.mainScreen.domain

import com.example.composedemo.mainScreen.data.MainScreenRepo
import com.example.composedemo.mainScreen.ui.model.MainScreenModel
import com.example.composedemo.mainScreen.ui.model.MainScreenOptions
import javax.inject.Inject

class AddConfigUseCase @Inject constructor(private val mainScreenRepo: MainScreenRepo){

    suspend operator fun invoke(mainScreenModel: MainScreenModel){
        mainScreenRepo.add(mainScreenModel)
    }
}