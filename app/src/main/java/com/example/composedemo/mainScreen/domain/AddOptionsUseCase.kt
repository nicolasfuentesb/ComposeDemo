package com.example.composedemo.mainScreen.domain

import com.example.composedemo.mainScreen.data.MainScreenOptionsRepo
import com.example.composedemo.mainScreen.ui.model.MainScreenOptions
import javax.inject.Inject

class AddOptionsUseCase @Inject constructor(private val mainScreenOptionsRepo: MainScreenOptionsRepo){

    suspend operator fun invoke(mainScreenOptions: MainScreenOptions){
        mainScreenOptionsRepo.add(mainScreenOptions)
    }
}