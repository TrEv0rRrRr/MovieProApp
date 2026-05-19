package pe.edu.upc.movieproapp.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.upc.movieproapp.features.home.data.local.MovieDao
import pe.edu.upc.movieproapp.features.home.data.local.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun eventDao(): MovieDao
}