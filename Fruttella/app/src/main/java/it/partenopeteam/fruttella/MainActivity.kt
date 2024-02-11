package it.partenopeteam.fruttella


import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.rememberNavController
import it.partenopeteam.fruttella.data.persistence.PreferencesManager
import it.partenopeteam.fruttella.routing.AppNavHost
import it.partenopeteam.fruttella.routing.NavigationItem
import it.partenopeteam.fruttella.ui.theme.FruttellaTheme
import it.partenopeteam.fruttella.view.OnboardingView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FruttellaTheme(dynamicColor = false) {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    PreferencesManager.init(this)
                    val isOnboardingCompleted = PreferencesManager.exists(AppConstants.ONBOARDING)
                    if(isOnboardingCompleted){
                        AppNavHost( startDestination = NavigationItem.FruitsList.route)
                    }else{
                        AppNavHost( startDestination = NavigationItem.Onboarding.route)
                    }


                }
            }
        }
    }
}
