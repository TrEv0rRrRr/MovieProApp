package pe.edu.upc.movieproapp.features.popular.presentation

import pe.edu.upc.movieproapp.features.popular.domain.model.Movie

data class PopularState(
    val movies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
