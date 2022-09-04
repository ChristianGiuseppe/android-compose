package com.example.weatherapp.repository

import com.example.weatherapp.data.DataOrException
import com.example.weatherapp.model.City
import com.example.weatherapp.model.Weather
import com.example.weatherapp.model.WeatherObject
import com.example.weatherapp.network.WeatherAPI
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    val api: WeatherAPI
) {

    suspend fun getWeather(city: String, units: String)
    : DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(city)
        } catch (e: Exception) {
            return DataOrException(e = e)
        }

        return DataOrException(data = response)
    }

}