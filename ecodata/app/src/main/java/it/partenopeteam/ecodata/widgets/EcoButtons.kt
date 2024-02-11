package it.partenopeteam.ecodata.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun PreviewFillEcoButton(){
    Column {
        EcoButton(textButton = "Bottone 1", onClick = { /*TODO*/ })
        Spacer(modifier = Modifier.height(8.dp))
        EcoButton(textButton = "Bottone 2 ", onClick = {}, filled = false)
    }

}

@Composable
fun EcoButton(textButton: String, onClick: ()-> Unit, filled: Boolean? = true){
    var modifier: Modifier = Modifier.height(56.dp)
    if(filled == true)
        modifier = modifier.fillMaxWidth()

    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
        Text(text = textButton, style= MaterialTheme.typography.bodyLarge)
    }
}

fun OutlinedEcoButton(textButton: String, onClick: () -> Unit, filled: Boolean){

}