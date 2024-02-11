package it.partenopeteam.fruttella.routing

enum class Screen {
    ONBOARDING,
    FRUITS_LIST,
    FRUIT_DETAIL,
    SETTINGS,
}
sealed class NavigationItem(val route: String) {
    object Onboarding : NavigationItem(Screen.ONBOARDING.name)
    object FruitsList : NavigationItem(Screen.FRUITS_LIST.name)
    object FruitDetail : NavigationItem(Screen.FRUIT_DETAIL.name)
    object Settings : NavigationItem(Screen.SETTINGS.name)

}