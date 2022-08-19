package com.example.triviaapp

import android.app.Application
import com.example.triviaapp.model.Question
import com.example.triviaapp.network.QuestionAPI
import com.example.triviaapp.util.Constants
import dagger.Provides
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@HiltAndroidApp
class TriviaApplication: Application() {
    @Singleton
    @Provides
    fun providerQuestionAPI(): QuestionAPI{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionAPI::class.java)
    }
}