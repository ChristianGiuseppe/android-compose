package com.example.firstapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier

import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstapp.ui.theme.FirstappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstappTheme {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstappTheme {
        CreateCard()
    }
}


@Composable
fun CreateCard() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .width(200.dp)
                .height(390.dp),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateProfileImage()
                Divider()
                CreateInfo()
                Button(onClick = {
                    Log.d("", "Button first app compose")
                    buttonClickedState.value =  !buttonClickedState.value ;

                }) {
                    Text(text = "Portfolio", style = MaterialTheme.typography.button)
                }
                if (buttonClickedState.value){
                    Content()
                } else {
                    Box{}
                }
            }


        }
    }
}

@Preview
@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            border = BorderStroke(2.dp, color = Color.LightGray)
        ){
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
        }
    }
}

@Composable
fun Portfolio(data:List<String>){
    LazyColumn(modifier =  Modifier.padding(8.dp)){
        items(data) { item -> 
            
            Card(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(), shape = RectangleShape) {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(16.dp)) {
                        CreateProfileImage(modifier = Modifier.size(80.dp).scale(1f).offset(y = -15.dp))
                    Column (modifier = Modifier.padding(8.dp).align(alignment = Alignment.CenterVertically)){
                        Text(text = item, fontWeight = FontWeight.Bold)
                    }
                    }

            }

        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = "Christian Nocerino", style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(text = "Android composer programmer", modifier = Modifier.padding(4.dp))
        Text(text = "Flutter composer programmer", modifier = Modifier.padding(4.dp))

    }
}

@Composable
private fun CreateProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(8.dp),
        shape = CircleShape,
        border = BorderStroke(width = 0.5.dp, color = Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_profile),
            contentDescription = "profile image",
            modifier = modifier
                .size(135.dp)
                .scale(1.4f)
                .offset(y = 20.dp)
        )
    }
}

