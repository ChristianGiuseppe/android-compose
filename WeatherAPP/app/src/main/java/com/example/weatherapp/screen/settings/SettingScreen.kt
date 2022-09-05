package com.example.weatherapp.screen.settings

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.weatherapp.widgets.WeatherAppBar

@Composable
fun SettingScreen (navController: NavController) {

    Scaffold(topBar = {
        WeatherAppBar(
            "Setting",
            navController = navController,
            icon = Icons.Default.ArrowBack,
            isMainScreen = false,
        ) {
            navController.popBackStack()
        }
    }) {

    }
}