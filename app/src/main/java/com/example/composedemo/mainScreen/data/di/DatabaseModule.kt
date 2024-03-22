package com.example.composedemo.mainScreen.data.di

import android.content.Context
import androidx.room.Room
import com.example.composedemo.mainScreen.data.database.MainScreenConfigDatabase
import com.example.composedemo.mainScreen.data.database.dao.MainScreenConfigDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideTodoDatabase(@ApplicationContext appContext: Context): MainScreenConfigDatabase{
        return Room.databaseBuilder(appContext, MainScreenConfigDatabase::class.java, "MainScreenDatabase").build()
    }

    @Provides
    fun provideMainScreenDao(mainScreenConfigDatabase: MainScreenConfigDatabase): MainScreenConfigDao{
        return mainScreenConfigDatabase.mainScreenDao()
    }
}