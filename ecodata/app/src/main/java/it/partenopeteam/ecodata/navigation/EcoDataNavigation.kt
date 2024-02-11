package it.partenopeteam.ecodata.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun EcoDataNavigation() {
    val navController = rememberNavController()
    val navBarNavController = rememberNavController()
    EcoDataNavHost(navController = navController, navBottomController = navBarNavController)
}