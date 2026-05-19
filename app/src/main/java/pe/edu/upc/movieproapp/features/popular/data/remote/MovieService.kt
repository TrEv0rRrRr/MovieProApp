package pe.edu.upc.movieproapp.features.popular.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    suspend fun getMovies(
        @Query("api_key") apiKey: String
    ): Response<MoviesResponseDto>
}