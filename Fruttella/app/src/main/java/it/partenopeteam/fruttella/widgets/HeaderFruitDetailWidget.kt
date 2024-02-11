package it.partenopeteam.fruttella.widgets

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import it.partenopeteam.fruttella.helper.getResourceIdFromFileName
import it.partenopeteam.fruttella.model.Fruit
import kotlinx.coroutines.launch

@Composable
fun HeaderFruitDetailWidget(fruit: Fruit){
    var isAnimating by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        launch {
            isAnimating = true
        }

    }

    val scale by animateFloatAsState(
        targetValue = if (isAnimating) 1.0f else 0.6f,
        animationSpec = tween(
            durationMillis = 500,
            easing = EaseInOut // Puoi scegliere l'interpolazione desiderata
        ), label = "scaleAnimation"
    )

    Image(
        modifier = Modifier
            .height(350.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = fruit.gradientColors
                )
            )
            .scale(scale),
        painter = painterResource(id = getResourceIdFromFileName(fruit.image)),
        contentDescription = fruit.title,
        contentScale = ContentScale.Fit
    )
}