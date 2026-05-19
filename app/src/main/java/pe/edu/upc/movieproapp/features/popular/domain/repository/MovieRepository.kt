package pe.edu.upc.movieproapp.features.popular.domain.repository

import kotlinx.coroutines.flow.Flow
import pe.edu.upc.movieproapp.features.popular.domain.model.Movie

interface MovieRepository {
    fun getMovies(): Flow<List<Movie>>

    fun getFavoriteMovies(): Flow<List<Movie>>

    suspend fun syncMovies()

    suspend fun toggleFavorite(id: Int)
}