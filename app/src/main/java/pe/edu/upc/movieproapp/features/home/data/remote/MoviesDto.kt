package pe.edu.upc.movieproapp.features.home.data.remote

import java.util.Date

data class MoviesDto(
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
