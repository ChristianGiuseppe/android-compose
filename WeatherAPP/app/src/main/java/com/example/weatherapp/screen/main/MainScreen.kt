package com.example.weatherapp.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherapp.data.DataOrException
import com.example.weatherapp.model.Weather
import com.example.weatherapp.navigation.WeatherScreens
import com.example.weatherapp.screen.main.MainViewModel
import com.example.weatherapp.ui.theme.darkWhite
import com.example.weatherapp.ui.theme.yellowDark
import com.example.weatherapp.utils.formatDate
import com.example.weatherapp.utils.formatDecimals
import com.example.weatherapp.widgets.*

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel = hiltViewModel(), city :String?) {
    val curCity: String = if (city!!.isBlank()) "Seattle" else city
    val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = viewModel.getWeatherData(city = curCity, "")
    }.value


    if(weatherData.loading == true){
        CircularProgressIndicator()
        return
    }
    ScaffoldMain(weather = weatherData.data!!, navController)
}


@Composable
fun ScaffoldMain(weather: Weather, navController: NavController) {
    Scaffold(topBar = {
        WeatherAppBar(
            title = weather.city.name + ",${weather.city.country}",
            icon = Icons.Default.ArrowBack,
            navController = navController,
            onAddActionClicked = {
                                 navController.navigate(WeatherScreens.SearchScreen.name)
            },
            elevation = 5.dp
        )
    }) {
        MainContent(weather)
    }
}

@Composable
fun MainContent(weather: Weather) {
    val weatherItem = weather.list[0]
    val imageUrl = "https://openweathermap.org/img/wn/${weatherItem.weather[0].icon}.png"
    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            formatDate(weather.list[0].dt),
            style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.onSecondary,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(6.dp)
        )

        Surface(
            modifier = Modifier
                .size(200.dp)
                .padding(4.dp), shape = CircleShape, color = yellowDark
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                WeatherStateImage(imageUrl)
                Text(
                    text = formatDecimals(weather.list[0].temp.day),
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.h4
                )
                Text(text = weather.list[0].weather[0].main, fontStyle = FontStyle.Italic)
            }

            HumidityPreassureWind(weatherItem = weather.list[0])
            Divider()
            SunSetAndSunRise(weatherItem = weather.list[0])
            Text(
                "This Week",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.subtitle1
            )

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                color = darkWhite,
                shape = RoundedCornerShape(
                    size = 14.dp
                )
            ) {
                LazyColumn(
                    modifier = Modifier.padding(2.dp),
                    contentPadding = PaddingValues(1.dp)
                ) {
                    items(items = weather.list) { item ->
                        WeekWeatherItem(weatherItem = item)
                    }
                }
            }

        }
    }
}


