package it.partenopeteam.fruttella.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SettingsRowWidget (label:String, text:String ){
    Row(modifier = Modifier.padding(8.dp)) {
        Text(text = label)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = text)
    }

}