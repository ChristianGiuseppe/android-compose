package it.partenopeteam.ecodata.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import it.partenopeteam.ecodata.navigation.BottomNavItem

val bottomNavigationItems = listOf(
    BottomNavItem.Home,
    BottomNavItem.GarbageCollection,
    BottomNavItem.Pollution,
    BottomNavItem.Upcycle
)

@Composable
fun EcoDataBottomNavigation(
    navController: NavHostController,
    onIndexChange: (Int) -> Unit,
    navigationSelectedItem: Int,
) {


        BottomNavigation(
            backgroundColor = MaterialTheme.colorScheme.surface,
            elevation = 8.dp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 24.dp,
                    bottom = 16.dp,
                    top = 10.dp
                ).shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(16.dp)
            ).clip(shape = RoundedCornerShape(16.dp))
        ) {
            bottomNavigationItems.forEachIndexed { index, navigationItem ->
                val selected = index == navigationSelectedItem;
                BottomNavigationItem(
                    selected = selected,
                    onClick = {
                        navController.navigate(navigationItem.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            restoreState = true
                            launchSingleTop = true
                            onIndexChange(index)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(navigationItem.icon),
                            contentDescription = navigationItem.title,
                            tint = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary.copy(
                                alpha = 0.4f
                            ),

                            )

                    },
                )
            }
        }
}
