package it.partenopeteam.ecodata.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import it.partenopeteam.ecodata.screen.GarbageCollectionScreen
import it.partenopeteam.ecodata.screen.HomeScreen
import it.partenopeteam.ecodata.screen.PollutionScreen
import it.partenopeteam.ecodata.screen.UpcycleScreen

@Composable
fun EcoDataBottomNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeScreen(navController)
        }
        composable(BottomNavItem.GarbageCollection.route) {
            GarbageCollectionScreen(navController)
        }
        composable(BottomNavItem.Pollution.route) {
            PollutionScreen(navController)
        }
        composable(BottomNavItem.Upcycle.route) {
            UpcycleScreen(navController)
        }
    }
}
