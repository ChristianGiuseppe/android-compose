package com.example.weatherapp.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherapp.model.Favorite
import com.example.weatherapp.navigation.WeatherScreens
import com.example.weatherapp.screen.favorite.FavoriteViewModel

@Composable
fun WeatherAppBar(
    title: String = "Title",
    icon: ImageVector? = null,
    navController: NavController,
    isMainScreen: Boolean = true,
    favoriteViewModel: FavoriteViewModel = hiltViewModel(),
    elevation: Dp = 0.dp,
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {}

) {

    val showDialog = remember {
        mutableStateOf(false)
    }

    if (showDialog.value) {
        ShowSettingsDropDownMenu(showDialog = showDialog, navController)
    }

    val showIt = remember {
        mutableStateOf(false)
    }
    TopAppBar(
        title = {
            Text(
                text = title,
                color = MaterialTheme.colors.onSecondary,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        },
        actions = {

            if (isMainScreen) {
                IconButton(onClick = {
                    onAddActionClicked.invoke()
                }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search icon")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Settings icon")
                }
            } else {
                Box {

                }
            }
        },
        navigationIcon = {
            if (icon != null)

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colors.onSecondary,
                    modifier = Modifier.clickable {
                        onButtonClicked.invoke();
                    })

            if (isMainScreen) {
                val isAlreadyFavList = favoriteViewModel
                    .favList.collectAsState().value.filter { item ->
                        (item.city == title.split(",")[0])
                    }

                if (isAlreadyFavList.isNullOrEmpty()) {

                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite icon",
                        modifier = Modifier
                            .scale(0.9f)
                            .clickable {
                                val dataList = title.split(",")
                                favoriteViewModel.addFavorite(
                                    Favorite(
                                        city = dataList[0], // city name
                                        country = dataList[1] // country code
                                    )
                                ).run {
                                    showIt.value = true
                                }
                            },
                        tint = Color.Red.copy(alpha = 0.6f)
                    )
                } else {
                    showIt.value = false
                    Box {}
                }
            }
        },
        backgroundColor = Color.Transparent,
        elevation = elevation,
    )
}

@Composable
fun ShowSettingsDropDownMenu(showDialog: MutableState<Boolean>, navController: NavController) {
    var expanded by remember {
        mutableStateOf(false)
    }

    val items = listOf<String>("Favorites", "About", "Settings")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
            .absolutePadding(top = 45.dp, right = 20.dp)
    ) {
        DropdownMenu(
            expanded = expanded, onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(140.dp)
                .background(Color.White)
        ) {
            items.forEachIndexed { index, text ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    showDialog.value = false
                }) {
                    Icon(
                        imageVector = when (text) {
                            "Favorites" -> Icons.Default.FavoriteBorder
                            "About" -> Icons.Default.Info
                            "Settings" -> Icons.Default.Settings
                            else -> {
                                Icons.Default.Settings
                            }
                        }, contentDescription = null, tint = Color.LightGray
                    )
                    Text(text = text, modifier = Modifier.clickable {
                        navController.navigate(
                            when (text) {
                                "Favorites" -> WeatherScreens.FavoriteScreen.name
                                "About" -> WeatherScreens.AboutScreen.name
                                "Settings" -> WeatherScreens.SettingsScreen.name
                                else -> {
                                    WeatherScreens.SettingsScreen.name
                                }
                            },
                        )
                    }, fontWeight = FontWeight.W300)
                }
            }

        }
    }
}
