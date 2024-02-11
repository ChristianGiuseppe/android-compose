package it.partenopeteam.fruttella.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.gson.Gson
import it.partenopeteam.fruttella.helper.getResourceIdFromFileName
import it.partenopeteam.fruttella.model.Fruit
import it.partenopeteam.fruttella.routing.NavigationItem
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun FruttellaRowWidget(fruit: Fruit, navController: NavController){

    Row(
        modifier = Modifier.padding(vertical = 8.dp)
            .clickable {
                var fruitDetail = Gson().toJson(fruit)
                val encodedJson = URLEncoder.encode(fruitDetail, StandardCharsets.UTF_8.toString())
                navController.navigate("${NavigationItem.FruitDetail.route}/$encodedJson")
            },
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically

        ) {
        Image(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(16.dp))
                .shadow(8.dp, shape = RoundedCornerShape(16.dp) )
                .background(
                    brush = Brush.verticalGradient(
                        colors = fruit.gradientColors
                    )
                ),
            painter = painterResource(id = getResourceIdFromFileName(fruit.image)),
            contentDescription = fruit.title,
            contentScale = ContentScale.Fit
        )

        Column (
            modifier = Modifier.wrapContentWidth().weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start) {
            Text(text = fruit.title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(text = fruit.headline, style = MaterialTheme.typography.bodySmall )
        }

        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Go to details",
            modifier = Modifier.size(24.dp),
            tint = Color.DarkGray
        )

    }
}