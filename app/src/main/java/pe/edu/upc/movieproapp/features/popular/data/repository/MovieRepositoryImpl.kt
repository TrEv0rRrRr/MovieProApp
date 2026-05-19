package pe.edu.upc.movieproapp.features.popular.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pe.edu.upc.movieproapp.features.popular.data.local.MovieDao
import pe.edu.upc.movieproapp.features.popular.data.mapper.toDomain
import pe.edu.upc.movieproapp.features.popular.data.mapper.toEntity
import pe.edu.upc.movieproapp.features.popular.data.remote.MovieService
import pe.edu.upc.movieproapp.features.popular.domain.model.Movie
import pe.edu.upc.movieproapp.features.popular.domain.repository.MovieRepository
import jakarta.inject.Inject
import jakarta.inject.Named

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    private val movieDao: MovieDao,
    @Named("apiKey") private val apiKey: String
): MovieRepository {
    override fun getMovies(): Flow<List<Movie>> {
        return movieDao.getMovies().map { entities -> entities.map { movieEntity -> movieEntity.toDomain() } }
    }

    override fun getFavoriteMovies(): Flow<List<Movie>> {
        return movieDao.getFavoriteMovies().map { entities -> entities.map { movieEntity -> movieEntity.toDomain() } }
    }

    override suspend fun syncMovies() {
        val response = movieService.getMovies(apiKey)
        if (response.isSuccessful) {
//            Log.d("API_TEST", response.body().toString())
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