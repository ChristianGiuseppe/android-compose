package com.example.weatherapp.screen.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherapp.model.Unit
import com.example.weatherapp.ui.theme.yellowDark
import com.example.weatherapp.widgets.WeatherAppBar

@Composable
fun SettingScreen(navController: NavController, settingsViewModel: SettingsViewModel = hiltViewModel()) {
    val unitToggleState by remember {
        mutableStateOf(false)
    }

    val measurement = listOf("Imperial (F)", "Metric (C)")
    val choiceFromdb = settingsViewModel.unitList.collectAsState().value
    val defaultChoice = if(choiceFromdb.isNullOrEmpty()) measurement[0]
    else choiceFromdb[0].unit

    val choiceDef by remember {
        mutableStateOf(0)
    }
    var choiceState by remember {
        mutableStateOf(defaultChoice)
    }
    Scaffold(topBar = {
        WeatherAppBar(
            "Setting",
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
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = "Change Units of Measurement",
                    modifier = Modifier.padding(bottom = 15.dp)
                )
                IconToggleButton(
                    checked = !unitToggleState,
                    onCheckedChange = {
                        if (unitToggleState) {
                            choiceState = measurement[0]
                        } else {
                            choiceState = measurement[1]
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .clip(shape = RectangleShape)
                        .padding(5.dp)
                        .background(
                            yellowDark
                        )
                ) {
                    Text(text = choiceState, style = MaterialTheme.typography.caption)
                }
            }

            Button(onClick = {
                settingsViewModel.deleteAllUnits()
                settingsViewModel.insertUnit(Unit(unit = choiceState))
            },
                modifier = Modifier.padding(3.dp),
                shape = RoundedCornerShape(34.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = yellowDark
                )) {
                Text(
                    text = "Save",
                    color = Color.White,
                    modifier = Modifier.padding(4.dp),
                    fontSize = 17.sp
                )

            }

        }
    }
}