package com.example.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weatherapp.screen.MainScreen
import com.example.weatherapp.screen.main.MainViewModel
import com.example.weatherapp.screen.WeatherSplashScreen
import com.example.weatherapp.screen.search.SearchScreen

@Composable
fun WeatherNavigation(){
    val navController = rememberNavController()
    NavHost(navController= navController,
        startDestination = WeatherScreens.SplashScreen.name){
        composable(WeatherScreens.SplashScreen.name){
            WeatherSplashScreen(navController= navController)
        }
        val route = WeatherScreens.MainScreen.name
        composable("${route}/city", arguments = listOf(
            navArgument(name = "city"){
                type = NavType.StringType
            }
        )){
            navBack -> navBack.arguments?.getString("city").let { city ->
            val viewModel  = hiltViewModel<MainViewModel>()
            MainScreen(navController= navController, viewModel, city = city)
        }

        }
        composable(WeatherScreens.SearchScreen.name){
            SearchScreen(navController= navController)
        }
    }

}