package com.example.personalitytestapp.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppController : Application() {

    override fun onCreate() {
        super.onCreate()
        ctx = this
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

    }

    companion object {
        val TAG: String = AppController::class.java
            .simpleName
        lateinit var ctx: AppController
        fun getAppContext(): AppController {
            return ctx
        }
    }
}