package pe.edu.upc.movieproapp.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Named
import jakarta.inject.Singleton
import pe.edu.upc.movieproapp.features.popular.data.remote.MovieService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Named("baseUrl")
    fun providesBaseUrl() = "https://api.themoviedb.org/3/"

    @Provides
    @Named("apiKey")
    fun providesApiKey() = "3cae426b920b29ed2fb1c0749f258325"

    @Provides
    @Singleton
    fun providesMovieService(retrofit: Retrofit): MovieService = retrofit.create(MovieService::class.java)

    @Provides
    @Singleton
    fun providesRetrofit(
        @Named("baseUrl") baseUrl: String
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}