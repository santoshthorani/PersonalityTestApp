package com.example.presentation_layer.utils

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate


object Util {
    fun getFinalResult(result: Int): String {
        return if (result % 2 == 0) "Extrovert" else "Introvert"
    }

    fun isNightMode(context: Context?): Boolean {
        return when (context?.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {
                Log.e("nightmode", "yes")
                true
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                Log.e("nightmode", "no")

                false
            }
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                Log.e("nightmode", "no")

                false
            }

            else -> false
        }
    }

    fun changeMode( checked: Boolean) {
        val mode = if (!checked) AppCompatDelegate.MODE_NIGHT_NO
        else AppCompatDelegate.MODE_NIGHT_YES

        AppCompatDelegate.setDefaultNightMode(mode)

    }

}