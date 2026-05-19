package pe.edu.upc.movieproapp.features.home.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface MovieService {
    @GET("movies")
    suspend fun getMovies(): Response<MoviesResponseDto>
}