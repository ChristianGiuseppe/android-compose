package it.partenopeteam.ecodata.navigation

import androidx.navigation.NamedNavArgument
import it.partenopeteam.ecodata.R


enum class EcoDataScreens {
    WELCOME,
    MAIN,
}

sealed class NavigationItem(val route: String) {
    object Welcome : NavigationItem(EcoDataScreens.WELCOME.name)
    object Main : NavigationItem(EcoDataScreens.MAIN.name)
}