package pe.edu.upc.movieproapp.features.popular.data.remote

data class MoviesResponseDto(
    val page: Int,
    val results: List<MovieDto>
)
