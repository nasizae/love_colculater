package com.example.lovecolculater.pref

import android.content.Context
import android.content.SharedPreferences
import dagger.Provides
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

 class Pref @Inject constructor(@ApplicationContext context: Context) {
    var preferences : SharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    fun isOnBoardingShow(): Boolean {
        return preferences.getBoolean(SHOWED_KEY, false)
    }

    fun onOnBoardingShowed() {
        preferences.edit().putBoolean(SHOWED_KEY, true).apply()
    }
    companion object{
        const val SHOWED_KEY = "seen_key"
    }

}