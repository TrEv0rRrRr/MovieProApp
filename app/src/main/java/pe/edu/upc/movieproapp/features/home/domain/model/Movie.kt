package pe.edu.upc.movieproapp.features.home.domain.model

// Acá va lo q te pide el ejercicio
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val popularity: Int,
    val isFavorite: Boolean
)
