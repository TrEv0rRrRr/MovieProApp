package pe.edu.upc.movieproapp.features.home.domain.repository

import kotlinx.coroutines.flow.Flow
import pe.edu.upc.movieproapp.features.home.domain.model.Movie

interface MovieRepository {
    fun getMovies(): Flow<List<Movie>>

    fun getFavoriteMovies(): Flow<List<Movie>>

    suspend fun syncMovies()

    suspend fun toggleFavorite(id: Int)
}