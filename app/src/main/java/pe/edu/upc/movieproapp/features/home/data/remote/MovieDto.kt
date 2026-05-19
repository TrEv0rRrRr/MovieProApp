package pe.edu.upc.movieproapp.features.home.data.remote

import java.util.Date

// Acá van todos y cada uno de los datos q vienen de la API
data class MovieDto(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val title: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Int,
    var posterPath: String,
    val releaseDate: Date,
    val softcore: Boolean,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)
