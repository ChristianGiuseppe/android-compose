package it.partenopeteam.ecodata.navigation

import it.partenopeteam.ecodata.R

sealed class BottomNavItem(var title:String, var icon:Int, var route:String) {
    object  Home : BottomNavItem("Home", R.drawable.home, "home")
    object  GarbageCollection: BottomNavItem("Raccolta Rifiuti", R.drawable.trash, "garbage_colletion")
    object  Pollution: BottomNavItem("Inquinamento", R.drawable.earth, "pollution")
    object  Upcycle: BottomNavItem("Riciclo", R.drawable.upcycle, "upcycle")
}