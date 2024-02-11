package it.partenopeteam.ecodata.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import it.partenopeteam.ecodata.screen.MainScreen
import it.partenopeteam.ecodata.screen.WelcomeScreen


@Composable
fun EcoDataNavHost(
    navController: NavHostController,
    navBottomController: NavHostController,
    startDestination: String = NavigationItem.Welcome.route
){
    NavHost(navController = navController, startDestination = startDestination){
        composable(NavigationItem.Welcome.route){
            WelcomeScreen(navController)

        }
        composable(NavigationItem.Main.route){
            MainScreen(navBottomController)
        }
    }
}