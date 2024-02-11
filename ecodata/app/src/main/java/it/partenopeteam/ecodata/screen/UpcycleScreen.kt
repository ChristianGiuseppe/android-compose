package it.partenopeteam.ecodata.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import it.partenopeteam.ecodata.ui.theme.typography

@Composable
fun UpcycleScreen (navController: NavController){
    Scaffold (
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .padding(paddingValues)
        ) {

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                //TITOLO
                Text(text = "Ricicla",
                    style = typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(8.dp))
                //DESCRIZIONE
                Text(text = "Trova ispirazione e risparmia, trasformando oggetti comuni in tesori ecologici. Sfrutta al massimo gli oggetti che hai a portata di mano, scopri modi intelligenti per dare nuova vita a materiali",  style = typography.bodySmall)

                //RICICLO DI ALCUNI MATERIALI
                //ARTICOLO E DETTAGLIO

                //SCRIVERE UN ARTICOLO

            }
        }
    }

}