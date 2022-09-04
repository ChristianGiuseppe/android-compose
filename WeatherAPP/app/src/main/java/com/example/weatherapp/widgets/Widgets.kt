package com.example.weatherapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.weatherapp.R
import com.example.weatherapp.model.WeatherItem
import com.example.weatherapp.ui.theme.yellowDark
import com.example.weatherapp.utils.formatDate
import com.example.weatherapp.utils.formatDateTime
import com.example.weatherapp.utils.formatDecimals

@Composable
fun HumidityPreassureWind(
    weatherItem: WeatherItem
) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.padding(4.dp)) {
            Image(
                painter = painterResource(id = R.drawable.humidity),
                contentDescription = "Humidity icon",
                modifier = Modifier.size(80.dp)
            )

            Text(
                text = "${weatherItem.humidity} %",
                style = MaterialTheme.typography.caption
            )
        }

        Row(modifier = Modifier.padding(4.dp)) {
            Image(
                painter = painterResource(id = R.drawable.pressure),
                contentDescription = "Preassure icon",
                modifier = Modifier.size(80.dp)
            )

            Text(
                text = "${weatherItem.pressure} psi",
                style = MaterialTheme.typography.caption
            )
        }

        Row(modifier = Modifier.padding(4.dp)) {
            Image(
                painter = painterResource(id = R.drawable.wind),
                contentDescription = "Wind icon",
                modifier = Modifier.size(80.dp)
            )

            Text(
                text = "${weatherItem.humidity} mpn",
                style = MaterialTheme.typography.caption
            )

        }
    }
}


@Composable
fun SunSetAndSunRise(weatherItem: WeatherItem) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.padding(4.dp)) {
            Image(
                painter = painterResource(id = R.drawable.sunset),
                contentDescription = "SunSet icon",
                modifier = Modifier.size(80.dp)
            )

            Text(
                text = "${formatDateTime(weatherItem.sunset)}:AM",
                style = MaterialTheme.typography.caption
            )
        }

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = "${formatDateTime(weatherItem.sunrise)}:PM",
                style = MaterialTheme.typography.caption
            )
            Image(
                painter = painterResource(id = R.drawable.sunrise),
                contentDescription = "SunRise icon",
                modifier = Modifier.size(80.dp)
            )

        }
    }
}


@Composable
fun WeekWeatherItem(weatherItem: WeatherItem) {
    val imageUrl = "https://openweathermap.org/img/wn/${weatherItem.weather[0].icon}.png"
    Surface(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 2.dp, bottom = 2.dp)
            .fillMaxWidth(),
        shape = CircleShape.copy(topStart = CornerSize(6.dp), topEnd = CornerSize(6.dp)),
        color = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = formatDate(weatherItem.dt).split(",")[0],
                modifier = Modifier.padding(4.dp)
            )

            WeatherStateImage(imageUrl)

            Surface(color = yellowDark, shape = CircleShape) {
                Text(text = weatherItem.weather[0].description, modifier = Modifier.padding(4.dp), style = MaterialTheme.typography.caption)
            }


            Text( text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color.Blue.copy(alpha = 0.7f),
                    fontWeight = FontWeight.SemiBold
                )
                ){
                    append(formatDecimals(weatherItem.temp.max) + "°")
                }

                withStyle(style = SpanStyle(
                    color = Color.LightGray.copy(alpha = 0.7f),
                    fontWeight = FontWeight.SemiBold
                )
                ){
                    append(formatDecimals(weatherItem.temp.min) + "°")
                }
            })

        }
    }
}

@Composable
fun WeatherStateImage(imageUrl: String) {
    Image(
        painter = rememberImagePainter(imageUrl),
        contentDescription = "icon image",
        modifier = Modifier.size(80.dp)
    )

}