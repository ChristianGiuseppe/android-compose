package com.example.weatherapp.screen.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.repository.WeatherDatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.weatherapp.model.Unit;


@HiltViewModel
class SettingsViewModel @Inject constructor(private val databaseRepository: WeatherDatabaseRepository): ViewModel() {
    private val _unitList = MutableStateFlow<List<Unit>>(emptyList())
    val unitList = _unitList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO)
        {
            databaseRepository.getUnit().distinctUntilChanged().collect { it ->
                if (!it.isNullOrEmpty()) {
                    _unitList.value = it
                }
            }
        }
    }


    fun insertUnit(unit: Unit) = viewModelScope.launch { databaseRepository.addUnit(unit) }
    fun updateUnit(unit: Unit) = viewModelScope.launch { databaseRepository.updateUnit(unit) }
    fun deleteUnit(unit: Unit) = viewModelScope.launch { databaseRepository.removeUnit(unit) }
    fun deleteAllUnits() = viewModelScope.launch { databaseRepository.removeAllUnit() }

}