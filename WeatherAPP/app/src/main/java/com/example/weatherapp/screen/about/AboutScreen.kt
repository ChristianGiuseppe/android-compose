package com.example.weatherapp.screen.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.weatherapp.R
import com.example.weatherapp.widgets.WeatherAppBar

@Composable
fun AboutScreen(navController: NavController) {
    Scaffold(topBar = {
        WeatherAppBar(
            "About",
            navController = navController,
            icon = Icons.Default.ArrowBack,
            isMainScreen = false,
        ) {
            navController.popBackStack()
        }
    }) {
        androidx.compose.material.Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.about_app),
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.subtitle1
                )

                Text(
                    text = stringResource(id = R.string.api_app),
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.subtitle1
                )
            }


        }

    }
}