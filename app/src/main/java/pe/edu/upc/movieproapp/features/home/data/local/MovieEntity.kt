package pe.edu.upc.movieproapp.features.home.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entidad de la base de datos
@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val popularity: Double,
    val isFavorite: Boolean
)
