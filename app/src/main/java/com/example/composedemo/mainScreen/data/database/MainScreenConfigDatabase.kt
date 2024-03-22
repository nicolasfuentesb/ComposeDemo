package com.example.composedemo.mainScreen.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composedemo.mainScreen.data.database.dao.MainScreenConfigDao
import com.example.composedemo.mainScreen.data.database.entities.MainScreenEntity
import com.example.composedemo.mainScreen.data.database.entities.OptionsEntity

@Database(
    entities = [MainScreenEntity::class, OptionsEntity::class],
    version = 2
)

abstract class MainScreenConfigDatabase : RoomDatabase() {
    abstract fun mainScreenDao() : MainScreenConfigDao
}