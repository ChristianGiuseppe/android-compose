package com.example.weatherapp.data

import androidx.room.*
import com.example.weatherapp.model.Favorite
import kotlinx.coroutines.flow.Flow
import com.example.weatherapp.model.Unit;

@Dao
interface  WeatherDao{

    @Query("SELECT * FROM fav_tbl")
    fun getFavorites() : Flow<List<Favorite>>


    @Query("SELECT * FROM fav_tbl WHERE city =:city")
    suspend fun getFavoriteById(city : String) : Favorite

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(item: Favorite)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFavorite(item: Favorite)

    @Query("DELETE FROM fav_tbl")
    suspend fun removeAllFavorite()

    @Delete
    suspend fun removeFavorite(item: Favorite)


    //Settings

    @Query("SELECT * FROM settings_tbl")
    fun getUnit(): Flow<List<Unit>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUnit(item: Unit)


    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUnit(item: Unit)

    @Query("DELETE FROM settings_tbl")
    suspend fun removeAllUnit()

    @Delete
    suspend fun removeUnit(item: Unit)
}