package com.example.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.movieapp.model.Movie


@Composable
fun MovieRow(movie: Movie, onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(movie.id)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        var expanded by remember {
            mutableStateOf(false)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            )
            {


                /*AsyncImage(
                    model = movie.poster,
                    contentDescription = "Movie image"
                )*/

                Image(painter = rememberImagePainter(data = movie.poster, builder = {
                    crossfade(true)
                    transformations(CircleCropTransformation())
                }), contentDescription = "")
            }
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1.0f)
            ) {
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Director ${movie.director}", style = MaterialTheme.typography.caption)
                Text(text = "Released ${movie.year}", style = MaterialTheme.typography.caption)

                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text(text = "Plot: ${movie.plot}", style = MaterialTheme.typography.caption)
                        Divider(modifier = Modifier.padding(4.dp))
                        Text(text = "Director ${movie.director}", style =  MaterialTheme.typography.caption)
                        Text(text = "Actors ${movie.actors}", style =  MaterialTheme.typography.caption)
                        Text(text = "Rating ${movie.rating}", style =  MaterialTheme.typography.caption)
                    }

                }



            }



            Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = "Down arrow",
                Modifier
                    .size(32.dp)
                    .padding(end = 8.dp)
                    .clickable {
                        expanded = !expanded
                    }, tint = Color.DarkGray
            )

        }


    }
}