package pe.edu.upc.movieproapp.features.home.presentation

import pe.edu.upc.movieproapp.features.home.domain.model.Movie

data class HomeState(
    val movies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
