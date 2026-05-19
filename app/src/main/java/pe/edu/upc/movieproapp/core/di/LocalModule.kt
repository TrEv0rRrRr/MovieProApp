package pe.edu.upc.movieproapp.core.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import pe.edu.upc.movieproapp.core.database.AppDatabase

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    @Singleton
    fun providesEventDao(appDatabase: AppDatabase) = appDatabase.eventDao()

    @Provides
    @Singleton
    fun providesAppDatabase(app: Application): AppDatabase = Room.databaseBuilder(
        context = app,
        klass = AppDatabase::class.java,
        name = "movies.db"
    ).fallbackToDestructiveMigration(true).build()
}