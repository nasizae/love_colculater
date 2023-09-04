package com.example.lovecolculater.module

import android.content.Context
import androidx.room.Room
import com.example.lovecolculater.model.Dao.AppDataBase
import com.example.lovecolculater.model.Dao.LoveDao
import com.example.lovecolculater.pref.Pref
import com.example.lovecolculater.presenter.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }
    @Provides
    fun providePref @Inject constructor(@ApplicationContext context: Context): Pref{
        return Pref(context)
    }

}
