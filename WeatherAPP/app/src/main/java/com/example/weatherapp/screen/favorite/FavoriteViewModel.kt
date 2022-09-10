package com.example.weatherapp.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.DataOrException
import com.example.weatherapp.model.Favorite
import com.example.weatherapp.model.Weather
import com.example.weatherapp.repository.WeatherDatabaseRepository
import com.example.weatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: WeatherDatabaseRepository) :
    ViewModel() {
    private val _favList = MutableStateFlow<List<Favorite>>(emptyList())
    val favList = _favList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.getFavorites().distinctUntilChanged().collect { listOfFav ->
                if (!listOfFav.isNullOrEmpty()) {
                    _favList.value = listOfFav
                }
            }
        }
    }


    suspend fun getFavoriteById(city: String): Favorite {
        return repository.getFavoriteById(city)
    }


     fun addFavorite(item: Favorite) {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.addFavorite(item)
        }
    }


     fun updateFavorite(item: Favorite) {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.updateFavorite(item)
        }
    }


     fun removeAllFavorite() {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.removeAllFavorite()
        }
    }

     fun removeFavorite(item: Favorite) {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.removeFavorite(item)
        }
    }
}

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository) : ViewModel() {

    suspend fun getWeatherData(city: String, units: String)
            : DataOrException<Weather, Boolean, Exception> {
        return repository.getWeather(city = city, units = units)

    }


}