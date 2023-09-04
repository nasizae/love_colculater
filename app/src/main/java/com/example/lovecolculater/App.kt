package com.example.lovecolculater

import android.app.Application
import androidx.room.Room
import com.example.lovecolculater.model.Dao.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        lateinit var appDataBase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDataBase = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "love-file")
            .allowMainThreadQueries().build()

    }
}