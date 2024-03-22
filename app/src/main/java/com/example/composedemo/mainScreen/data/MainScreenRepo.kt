package com.example.composedemo.mainScreen.data

import com.example.composedemo.mainScreen.data.database.dao.MainScreenConfigDao
import com.example.composedemo.mainScreen.data.database.entities.MainScreenEntity
import com.example.composedemo.mainScreen.ui.model.MainScreenModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainScreenRepo @Inject constructor(private val mainScreenConfigDao: MainScreenConfigDao){

    val getConfig: Flow<List<MainScreenModel>> =
        mainScreenConfigDao.getMainScreenConfig().map { config -> config.map { MainScreenModel(
            it.id, it.background_color,
            it.drawer_background_color,
            it.drawer_text_color,
            it.top_bar_background_color,
            it.top_bar_scroll_color,
            it.button_color,
            it.button_icon_color) } }

    suspend fun add(mainScreenModel: MainScreenModel){
        mainScreenConfigDao.insertConfig(MainScreenEntity(
            mainScreenModel.id,
            mainScreenModel.background_color,
            mainScreenModel.drawer_background_color,
            mainScreenModel.drawer_text_color,
            mainScreenModel.top_bar_background_color,
            mainScreenModel.top_bar_scroll_color,
            mainScreenModel.button_color,
            mainScreenModel.button_icon_color))
    }


}