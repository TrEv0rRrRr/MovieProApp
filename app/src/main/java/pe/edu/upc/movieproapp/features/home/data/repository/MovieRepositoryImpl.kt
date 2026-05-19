package pe.edu.upc.movieproapp.features.home.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pe.edu.upc.movieproapp.features.home.data.local.MovieDao
import pe.edu.upc.movieproapp.features.home.data.mapper.toDomain
import pe.edu.upc.movieproapp.features.home.data.mapper.toEntity
import pe.edu.upc.movieproapp.features.home.data.remote.MovieService
import pe.edu.upc.movieproapp.features.home.domain.model.Movie
import pe.edu.upc.movieproapp.features.home.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    private val movieDao: MovieDao
): MovieRepository {
    override fun getMovies(): Flow<List<Movie>> {
        return movieDao.getMovies().map { entities -> entities.map { movieEntity -> movieEntity.toDomain() } }
    }

    override fun getFavoriteMovies(): Flow<List<Movie>> {
        return movieDao.getFavoriteMovies().map { entities -> entities.map { movieEntity -> movieEntity.toDomain() } }
    }

    override suspend fun syncMovies() {
        val response = movieService.getMovies()
        if (response.isSuccessful) {
            response.body()?.let { moviesResponseDto -> moviesResponseDto.results.forEach { movieDto ->
                val localMovie = movieDao.getMovieById(movieDto.id)
                val entity = movieDto.toEntity(localMovie?.isFavorite ?: false)
                movieDao.upsert(entity)
            } }
        }
    }

    override suspend fun toggleFavorite(id: Int) {
        movieDao.toggleFavorite(id)
    }

}