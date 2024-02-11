package it.partenopeteam.ecodata.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import it.partenopeteam.ecodata.R
import it.partenopeteam.ecodata.navigation.NavigationItem
import it.partenopeteam.ecodata.ui.theme.typography
import it.partenopeteam.ecodata.widgets.EcoButton


@Composable
fun WelcomeScreen(navigation: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            //Image
            //Title
            Image(
                painter = painterResource(id = R.drawable.welcome),
                contentDescription = "welcome",
                modifier = Modifier.weight(2.5f)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Inizia la tua rivoluzione verde con noi!",
                style = typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Esplora le funzionalità dell'app, scopri consigli pratici, partecipa a sfide ecologiche e segui il tuo progresso nel ridurre l'impatto ambientale.",
                style = typography.bodyLarge
            )
            Spacer(modifier = Modifier.weight(1f))
            EcoButton(textButton = "Avanti", onClick = {
                navigation.navigate(NavigationItem.Main.route)
            })

            //Button
        }
    }
}