package com.example.jettipapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jettipapp.components.InputField
import com.example.jettipapp.components.RoundedIconsButton
import com.example.jettipapp.ui.theme.JetTipAppTheme
import com.example.jettipapp.util.calculateTotalPerPerson
import com.example.jettipapp.util.calculateTotalTip

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Text(text = "Hello Again")
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetTipAppTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {

                MainContent()

        }
    }

}

@Composable
fun TopHeader(totalPerPerson: Double = 0.0) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 150.dp),
        color = Color(0xFFE9D7F7)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val total = "%.2f".format(totalPerPerson)
            Text(text = "Totale per persona", style = MaterialTheme.typography.h5)
            Text(
                text = "$${total}",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Preview
@Composable
@ExperimentalComposeUiApi
fun MainContent() {
    val numberSplit = remember {
        mutableStateOf(1)
    }


    val tipAmount = remember {
        mutableStateOf(0.0)
    }

    val totalPerPerson = remember {
        mutableStateOf(0.0)
    }
    Column {
        TopHeader(totalPerPerson.value)
        BillForm(
            splitByState = numberSplit,
            tipAmountState = tipAmount,
            totalPerPersonState = totalPerPerson
        ){}
    }


}

@ExperimentalComposeUiApi
@Composable
fun BillForm(
    modifier: Modifier = Modifier,
    splitByState: MutableState<Int>,
    tipAmountState: MutableState<Double>,
    totalPerPersonState: MutableState<Double>,
    onValueChange: (String) -> Unit = {}
) {

    val totalBillState = remember {
        mutableStateOf("")
    }

    val valiState = remember(totalBillState.value) {
        totalBillState.value.trim().isNotEmpty()
    }

    val sliderState = remember {
        mutableStateOf(0f);
    }

    val tipPercentage = (sliderState.value * 100).toInt();



    val keyboardController = LocalSoftwareKeyboardController.current


    Surface(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.0.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {
        Column() {
            InputField(
                Modifier.fillMaxWidth(),
                valueState = totalBillState,
                labelId = "Inserisci il Prezzo",
                enabled = true,
                isSingleLine = true,
                onAction = KeyboardActions {
                    if (!valiState)
                    //TODO  - onvaluechanged
                        onValueChange(totalBillState.value.trim())

                    keyboardController?.hide()
                }
            )
            if (valiState){
                Row(
                    modifier = Modifier.padding(bottom = 10.dp, start = 10.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Split",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .weight(1f)
                    )
                    Spacer(modifier = Modifier.width(120.dp))
                    Row(modifier = Modifier.padding(4.dp), horizontalArrangement = Arrangement.End) {
                        RoundedIconsButton(imageVector = Icons.Default.Remove, onClick = {
                            if(splitByState.value > 1){
                                splitByState.value --

                            }
                            totalPerPersonState.value = calculateTotalPerPerson(totalBillState.value.toDouble(), splitByState.value, tipPercentage)
                        })
                        Text(text = splitByState.value.toString(), modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 8.dp, end = 8.dp))
                        RoundedIconsButton(imageVector = Icons.Default.Add, onClick = {
                            splitByState.value ++
                            totalPerPersonState.value = calculateTotalPerPerson(totalBillState.value.toDouble(), splitByState.value, tipPercentage)
                        })
                    }
                }
                
                Row(modifier = Modifier.padding(bottom = 10.dp, start = 10.dp, end= 10.dp)) {
                    Text(text = "Tip",  modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                        .weight(1f))
                    Spacer(modifier = Modifier.width(200.dp))
                    Text(text = "$${tipAmountState.value}")
                }

                Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(bottom = 10.dp, start = 10.dp, end= 10.dp)) {
                    Text(text = "$tipPercentage%",  modifier = Modifier.align(alignment = Alignment.End))
                    Spacer(modifier = Modifier.height(40.dp))
                    Slider(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        steps = 5,
                        value = sliderState.value, onValueChange ={
                        sliderState.value = it;
                            tipAmountState.value = calculateTotalTip(totalBillState.value.toDouble(), tipPercentage)
                            totalPerPersonState.value = calculateTotalPerPerson(totalBillState.value.toDouble(), splitByState.value, tipPercentage)
                    } )
                }
            }
            else
                Box {}
        }
    }
}


