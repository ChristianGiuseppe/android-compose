package it.partenopeteam.ecodata.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Sizes (
    val smaller: Dp = 8.dp,
    val small: Dp = 16.dp,
    val medium: Dp = 32.dp,
    val large: Dp = 64.dp,

    val icon: Dp = 24.dp,
    val largeIcon: Dp = 32.dp,

    val topBarHeight: Dp = 56.dp,
    val bottomBarHeight: Dp = 56.dp,
)

internal val LocalSizes = staticCompositionLocalOf { Sizes() }