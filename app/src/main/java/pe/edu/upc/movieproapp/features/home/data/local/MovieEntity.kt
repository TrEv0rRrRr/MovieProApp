package pe.edu.upc.movieproapp.features.home.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val overview: String,
    val popularity: Int,
    val isFavorite: Boolean
)
