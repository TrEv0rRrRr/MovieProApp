package pe.edu.upc.movieproapp.features.popular.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    // Flow -> Para la reactividad, si se actualiza la bd, lo que ve el user también
    @Query("SELECT * FROM movies")
    fun getMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movies WHERE isFavorite = 1")
    fun getFavoriteMovies(): Flow<List<MovieEntity>>

    // ? -> Significa q lo q devuelve puede ser null
    @Query("SELECT * FROM movies WHERE id = :id")
    suspend fun getMovieById(id: Int): MovieEntity?

    // Permite insertar si el registro no ha sido creado o actualizar si ya existe
    @Upsert
    suspend fun upsert(movie: MovieEntity)

    @Query("UPDATE movies SET isFavorite = NOT isFavorite WHERE id = :id")
    suspend fun toggleFavorite(id: Int)
}