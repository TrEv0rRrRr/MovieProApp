package pe.edu.upc.movieproapp.features.home.domain.model

import java.util.Date

data class Movie(
    val title: String,
    val overview: String,
    val popularity: Int,
    val isFavorite: Boolean
)
