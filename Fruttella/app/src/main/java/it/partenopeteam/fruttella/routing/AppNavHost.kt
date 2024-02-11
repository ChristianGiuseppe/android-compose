package it.partenopeteam.fruttella.routing

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import it.partenopeteam.fruttella.view.FruitDetailView
import it.partenopeteam.fruttella.view.FruitListView
import it.partenopeteam.fruttella.view.OnboardingView
import it.partenopeteam.fruttella.view.SettingsView
import java.net.URLDecoder
import java.nio.charset.StandardCharsets


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: String,
    ) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Onboarding.route) {
            OnboardingView(navController)
        }
        composable(NavigationItem.FruitsList.route) {
            FruitListView(navController)
        }
        composable("${NavigationItem.FruitDetail.route}/{fruitDetail}",
            arguments = listOf(navArgument("fruitDetail") { type = NavType.StringType })
        ) {
                backStackEntry ->

            FruitDetailView(fruitDetail =backStackEntry.arguments?.getString("fruitDetail"), )
        }
        
        composable(NavigationItem.Settings.route){
            SettingsView()
        }
    }
}