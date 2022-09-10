package com.example.weatherapp.screen.favorite

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherapp.model.Favorite
import com.example.weatherapp.navigation.WeatherScreens
import com.example.weatherapp.ui.theme.GreyLight
import com.example.weatherapp.ui.theme.WhiteDark
import com.example.weatherapp.widgets.WeatherAppBar

@Composable
fun FavoriteScreen(navController: NavController, favoriteViewModel: FavoriteViewModel) {
    Scaffold(topBar = {
        WeatherAppBar(
            "Favorite Cities",
            navController = navController,
            icon = Icons.Default.ArrowBack,
            isMainScreen = false,
        ) {
            navController.popBackStack()
        }
    }) {
        Surface(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val list = favoriteViewModel.favList.collectAsState().value
                LazyColumn {
                    items(items = list) {
                        CityRow(it, navController = navController, favoriteViewModel)
                    }
                }
            }
        }

    }
}

@Composable
fun CityRow(
    it: Favorite,
    navController: NavController,
    favoriteViewModel: FavoriteViewModel
) {
    Surface(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .height(50.dp)
            .clickable {
                navController.navigate(WeatherScreens.MainScreen.name+ "/${it.city}")
            },
        shape = CircleShape.copy(topEnd = CornerSize(6.dp)),  color= GreyLight){
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text= it.city, modifier = Modifier.padding(start = 4.dp) )

            androidx.compose.material.Surface (modifier =  Modifier.padding(4.dp), shape = CircleShape, color = WhiteDark){
                    Text(text = it.country, modifier = Modifier.padding(4.dp), style = MaterialTheme.typography.caption)
            }
            
            Icon(imageVector = Icons.Rounded.Delete, contentDescription = "Delete" ,Modifier.clickable {  } , tint = Color.Red)
        }
    }

}
