package it.partenopeteam.fruttella.widgets

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.partenopeteam.fruttella.R

@Composable
fun FruttellaButtonWidget(text: String, isNext: Boolean = false ){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .border(1.25.dp, Color.White, shape = RoundedCornerShape(percent = 50))
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors( containerColor = Color.White)

    ) {
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)){
            Text(text = text, color = Color.Black)
            Spacer(Modifier.width(8.dp))
            if(isNext) Image(painter = painterResource(id = R.drawable.round_arrow_right), contentDescription = "arrow right", Modifier.size(24.dp) )
        }

    }


}

@Composable
fun FruttellaOutlinedButtonWidget(text:String, isNext: Boolean = false, colorBtn: Color, onClick: () -> Unit){
    OutlinedButton(
        colors = ButtonDefaults.buttonColors( containerColor = Color.Transparent),
        border = BorderStroke(2.dp, color = colorBtn),
        onClick = onClick) {
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)){
            Text(text = text, color = colorBtn, fontSize = 18.sp)
            Spacer(Modifier.width(8.dp))
            if(isNext)Icon(
                painter = painterResource(id = R.drawable.round_arrow_right),
                "Google logo",
                tint= colorBtn
            )
        }
    }
}