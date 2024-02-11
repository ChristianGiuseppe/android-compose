package it.partenopeteam.fruttella.model

import androidx.compose.ui.graphics.Color

data class Fruit(
    val title: String,
    val headline: String,
    val image: String,
    val gradientColors: List<Color>,
    val description: String,
    val nutrition: List<String>
)
