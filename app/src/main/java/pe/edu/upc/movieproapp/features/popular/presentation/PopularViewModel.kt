package pe.edu.upc.movieproapp.features.popular.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.edu.upc.movieproapp.features.popular.domain.repository.MovieRepository

@HiltViewModel
class PopularViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private val _state = MutableStateFlow(PopularState())
    val state: StateFlow<PopularState> = _state

    init {
        observeMovies()
        syncMovies()
    }

    private fun observeMovies() {
        viewModelScope.launch {
            movieRepository.getMovies()
                .collect { movies -> _state.update { it.copy(movies = movies) } }
        }
    }

    private fun syncMovies() {
        _state.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            try {
                movieRepository.syncMovies()
                _state.update { it.copy(isLoading = false) }

            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message?: "Sync failed") }
            }
        }
    }

    fun toggleFavorite(id: Int) {
        viewModelScope.launch {
            movieRepository.toggleFavorite(id)
        }
    }
}