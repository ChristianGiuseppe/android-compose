package it.partenopeteam.ecodata.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import it.partenopeteam.ecodata.navigation.EcoDataBottomNavHost
import it.partenopeteam.ecodata.widgets.EcoDataBottomNavigation


@Composable
fun MainScreen(navBottomBarController: NavHostController) {
    var navigationSelectedItem by remember {
        mutableStateOf(0)
    }

    Scaffold(
        floatingActionButton = {
            if (navigationSelectedItem == 3) FloatingActionButton(
                modifier = Modifier
                    .padding(all = 16.dp),
                containerColor = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(12.dp),
                onClick = {

                }
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
            }

        },
        bottomBar = {
            EcoDataBottomNavigation(navController = navBottomBarController, onIndexChange = {
                navigationSelectedItem = it
            }, navigationSelectedItem)
        }


    ) { paddingValue ->
        EcoDataBottomNavHost(navController = navBottomBarController)
        Modifier.padding(paddingValue)
    }
}