package pe.edu.upc.movieproapp.features.home.data.remote

data class MoviesResponseDto(
    val page: Int,
    val results: List<MoviesDto>
)
