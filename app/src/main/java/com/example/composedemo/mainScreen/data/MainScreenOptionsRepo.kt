package com.example.composedemo.mainScreen.data

import com.example.composedemo.mainScreen.data.database.dao.MainScreenConfigDao
import com.example.composedemo.mainScreen.data.database.entities.OptionsEntity
import com.example.composedemo.mainScreen.ui.model.MainScreenOptions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainScreenOptionsRepo @Inject constructor(private val mainScreenConfigDao: MainScreenConfigDao){

    val getOptions: Flow<List<MainScreenOptions>> =
        mainScreenConfigDao.getOptions().map { config -> config.map { MainScreenOptions(
            it.option1,
            it.option2,
            it.option3,
            it.option4) } }

    suspend fun add(mainScreenOptions: MainScreenOptions){
        mainScreenConfigDao.insertOptions(
            OptionsEntity(
                mainScreenOptions.option1,
                mainScreenOptions.option2,
                mainScreenOptions.option3,
                mainScreenOptions.option4)
        )
    }
}