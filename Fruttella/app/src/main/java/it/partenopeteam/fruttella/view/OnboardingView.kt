package it.partenopeteam.fruttella.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState

import androidx.compose.runtime.Composable


import it.partenopeteam.fruttella.data.fruitsData
import it.partenopeteam.fruttella.widgets.FruitCardWidget
import it.partenopeteam.fruttella.widgets.IndicatorWidget

import androidx.navigation.NavController
import androidx.navigation.NavHostController


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingView(navController: NavController) {
    val sizeDataset =  fruitsData.count()
    val pagerState = rememberPagerState(
       pageCount = {
           sizeDataset
       }
    )


    HorizontalPager(
         state =  pagerState) { page ->
        FruitCardWidget(fruitsData[page], pagerState = pagerState, pageIndex = page, navController= navController)

    }
    IndicatorWidget(pagerState = pagerState, size= sizeDataset )
}