package pe.edu.upc.movieproapp.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pe.edu.upc.movieproapp.features.home.data.repository.MovieRepositoryImpl
import pe.edu.upc.movieproapp.features.home.domain.repository.MovieRepository

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    fun providesMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}