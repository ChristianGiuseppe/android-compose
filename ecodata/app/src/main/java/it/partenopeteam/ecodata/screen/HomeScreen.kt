package it.partenopeteam.ecodata.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navigation: NavController) {
    Column {
        Text(text = "Home")
    }
}