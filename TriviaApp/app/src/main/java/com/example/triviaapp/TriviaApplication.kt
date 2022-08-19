package com.example.triviaapp

import android.app.Application
import com.example.triviaapp.model.Question
import com.example.triviaapp.network.QuestionAPI
import com.example.triviaapp.repository.QuestionRepository
import com.example.triviaapp.util.Constants
import dagger.Provides
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@HiltAndroidApp
class TriviaApplication: Application() {
}