package it.partenopeteam.fruttella.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import com.google.gson.Gson
import it.partenopeteam.fruttella.model.Fruit

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.partenopeteam.fruttella.widgets.DisclosureGroupWidget
import it.partenopeteam.fruttella.widgets.HeaderFruitDetailWidget
import java.net.URLDecoder
import java.nio.charset.StandardCharsets


@Composable
fun FruitDetailView(fruitDetail: String?) {
    val nutrients = arrayListOf("Energia", "Zuccheri", "Grassi", "Proteine", "Vitamine", "Minerali")
    val param = URLDecoder.decode(fruitDetail, StandardCharsets.UTF_8.toString())
    val fruitObject = Gson().fromJson(param, Fruit::class.java)


    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())

    ) {
        HeaderFruitDetailWidget(fruitObject)

        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = fruitObject.title,
                style = MaterialTheme.typography.displayMedium,
                color = fruitObject.gradientColors[1],
                fontWeight = FontWeight.ExtraBold
            )

            Text(text = fruitObject.headline, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))

            DisclosureGroupWidget(title = "Nutrienti per 100g", content = {
                Column {
                    nutrients.forEachIndexed { index, nutrient ->
                        Row {
                            Text(text = nutrient)
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = fruitObject.nutrition[index],
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            })
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Informazioni: ${fruitObject.title}",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = fruitObject.gradientColors[1],
                    fontSize = 18.sp
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = fruitObject.description,
                style = TextStyle(
                    fontSize = 14.sp
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }
    }
}