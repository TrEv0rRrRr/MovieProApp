package pe.edu.upc.movieproapp.features.popular.data.mapper

import pe.edu.upc.movieproapp.features.popular.data.local.MovieEntity
import pe.edu.upc.movieproapp.features.popular.data.remote.MovieDto
import pe.edu.upc.movieproapp.features.popular.domain.model.Movie

fun MovieEntity.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        posterPath = posterPath,
        overview = overview,
        popularity = popularity,
        isFavorite = isFavorite
    )
}

fun MovieDto.toEntity(isFavorite: Boolean): MovieEntity {
    return MovieEntity(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath,
        popularity = popularity,
        isFavorite = isFavorite
    )
}