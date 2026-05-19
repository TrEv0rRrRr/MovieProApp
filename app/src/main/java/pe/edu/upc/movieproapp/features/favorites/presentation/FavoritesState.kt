package pe.edu.upc.movieproapp.features.favorites.presentation

import pe.edu.upc.movieproapp.features.popular.domain.model.Movie

data class FavoritesState(
    val movies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)