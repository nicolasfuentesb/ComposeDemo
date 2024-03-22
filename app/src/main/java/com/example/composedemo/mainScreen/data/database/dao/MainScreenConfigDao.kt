package com.example.composedemo.mainScreen.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.composedemo.mainScreen.data.database.entities.MainScreenEntity
import com.example.composedemo.mainScreen.data.database.entities.OptionsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MainScreenConfigDao {

    @Upsert
    suspend fun insertConfig(mainScreenConfig: MainScreenEntity)

    @Query("SELECT * FROM MainScreenEntity")
    fun getMainScreenConfig(): Flow<List<MainScreenEntity>>

    @Upsert
    suspend fun insertOptions(optionsEntity: OptionsEntity)

    @Query("SELECT * FROM OptionsEntity")
    fun getOptions(): Flow<List<OptionsEntity>>

}