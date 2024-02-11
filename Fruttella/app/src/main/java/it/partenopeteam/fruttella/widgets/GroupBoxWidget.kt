package it.partenopeteam.fruttella.widgets

import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.partenopeteam.fruttella.ui.theme.semiTransparentColor

@Composable
fun GroupBoxWidget(title: String, icon: ImageVector, body: @Composable () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = semiTransparentColor, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row {
                Text(text = title.uppercase(),
                    style = TextStyle(
                    fontWeight = FontWeight.Bold,

                    fontSize = 18.sp
                ),)

                Spacer(Modifier.weight(1f))
                Icon(icon, contentDescription = icon.toString())
            }

            Divider(modifier = Modifier.padding(vertical = 8.dp))


            body()

        }
    }
}