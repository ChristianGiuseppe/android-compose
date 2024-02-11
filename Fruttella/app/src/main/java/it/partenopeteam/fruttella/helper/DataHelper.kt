package it.partenopeteam.fruttella.helper

import it.partenopeteam.fruttella.R


fun getResourceIdFromFileName(fileName: String): Int {
    return when (fileName) {
        "blueberry" -> R.drawable.blueberry
        "strawberry" -> R.drawable.strawberry
        "lemon" -> R.drawable.lemon
        //else -> R.drawable.default_image
        else -> R.drawable.blueberry // Immagine di default nel caso in cui il nome non corrisponda
    }
}