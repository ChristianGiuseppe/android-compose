package it.partenopeteam.fruttella.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import it.partenopeteam.fruttella.data.fruitsData
import it.partenopeteam.fruttella.routing.NavigationItem
import it.partenopeteam.fruttella.widgets.FruttellaRowWidget

@ExperimentalMaterial3Api
@Composable
fun FruitListView(navController: NavController) {

    val dataFruits = fruitsData
    Scaffold(
        topBar = {
            TopAppBar(
                title = {  },
                actions = {
                    IconButton(onClick = {  navController.navigate(NavigationItem.Settings.route) }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        }
    ){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(horizontal = 16.dp)){
            Text("Fruttella",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.displayMedium)

            LazyColumn(){
                this.itemsIndexed(dataFruits){index, fruit ->
                    FruttellaRowWidget(fruit, navController = navController)
                    if (index < dataFruits.lastIndex)
                        Divider(color = Color.DarkGray, thickness = 1.dp)
                }
            }
        }

    }
}