package com.example.weatherapp.repository

import androidx.room.*
import com.example.weatherapp.data.WeatherDao
import com.example.weatherapp.model.Favorite
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.example.weatherapp.model.Unit;
class WeatherDatabaseRepository @Inject constructor(private val weatherDao: WeatherDao) {


    fun getFavorites() : Flow<List<Favorite>>{
        return weatherDao.getFavorites()
    }


    suspend fun getFavoriteById(city : String) : Favorite{
        return  weatherDao.getFavoriteById(city)
    }


    suspend fun addFavorite(item: Favorite){
        weatherDao.addFavorite(item)
    }


    suspend fun updateFavorite(item: Favorite){
        weatherDao.updateFavorite(item)
    }


    suspend fun removeAllFavorite(){
        weatherDao.removeAllFavorite()
    }

    suspend fun removeFavorite(item: Favorite){
        weatherDao.removeFavorite(item)
    }



    fun getUnit(): Flow<List<Unit>>{
        return weatherDao.getUnit()
    }


    suspend fun addUnit(item: Unit){
        return weatherDao.addUnit(item)
    }



    suspend fun updateUnit(item: Unit){
        return weatherDao.updateUnit(item)
    }


    suspend fun removeAllUnit(){
        weatherDao.removeAllUnit()
    }


    suspend fun removeUnit(item: Unit){
        weatherDao.removeUnit(item)
    }
}