@file:OptIn(ExperimentalFoundationApi::class)

package it.partenopeteam.fruttella.widgets

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import it.partenopeteam.fruttella.AppConstants
import it.partenopeteam.fruttella.data.persistence.PreferencesManager
import it.partenopeteam.fruttella.helper.getResourceIdFromFileName
import it.partenopeteam.fruttella.model.Fruit
import it.partenopeteam.fruttella.routing.NavigationItem
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FruitCardWidget(fruit: Fruit, pagerState: PagerState, pageIndex: Int, navController: NavController) {

    // Determina se l'elemento è abbastanza vicino al centro per avviare l'animazione
    val pageOffset = (
            (pagerState.currentPage - pageIndex) + pagerState
                .currentPageOffsetFraction
            ).absoluteValue

    val isCentered = remember(pageOffset) {
        pageOffset < 0.5
    }


    var isAnimating by remember { mutableStateOf(false) }

    LaunchedEffect(isCentered) {
        launch {
            isAnimating = isCentered
        }

    }

    val scale by animateFloatAsState(
        targetValue = if (isAnimating) 1.0f else 0.6f,
        animationSpec = tween(
            durationMillis = 500,
            easing = EaseInOut // Puoi scegliere l'interpolazione desiderata
        ), label = "scaleAnimation"
    )

    Column(

        modifier = Modifier
            .fillMaxHeight()
            .padding(20.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors =
                    fruit.gradientColors
                )
            ),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(id = getResourceIdFromFileName(fruit.image)),
            contentDescription = null,
            modifier = Modifier.graphicsLayer {
                scaleX = scale
                scaleY= scale
            },

            contentScale = ContentScale.Inside
        )
        Spacer(Modifier.height(20.dp))
        Text(
            text = fruit.title,
            color = Color.White,
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)

        )
        Spacer(Modifier.height(20.dp))
        // Sottotitolo/headline del frutto
        Text(
            text = fruit.headline,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)

        )
        Spacer(Modifier.height(20.dp))
        FruttellaOutlinedButtonWidget(text = "Avanti", isNext = true, colorBtn = Color.White, onClick = {
            PreferencesManager.setValue(AppConstants.ONBOARDING, true)
            navController.navigate(NavigationItem.FruitsList.route)
        })

    }



}


