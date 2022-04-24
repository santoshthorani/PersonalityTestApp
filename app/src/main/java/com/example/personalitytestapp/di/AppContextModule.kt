package com.example.personalitytestapp.di

import android.content.Context
import com.example.personalitytestapp.app.AppController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppContextModule {
    @Provides
    fun getApplicationContext(): Context = AppController.getAppContext().applicationContext
}