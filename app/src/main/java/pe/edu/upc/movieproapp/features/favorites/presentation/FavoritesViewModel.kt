package pe.edu.upc.movieproapp.features.favorites.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import pe.edu.upc.movieproapp.features.popular.domain.repository.MovieRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val movieRepo: MovieRepository
): ViewModel() {
    private val _state = MutableStateFlow(FavoritesState())
    val state: StateFlow<FavoritesState> = _state

    init { observeFavorites() }

    private fun observeFavorites() {
        viewModelScope.launch {
            movieRepo.getFavoriteMovies().collect { movies ->
                _state.update { it.copy(movies = movies) }
            }
        }
    }

    fun toggleFavorite(id: Int) {
        viewModelScope.launch {
            movieRepo.toggleFavorite(id)
        }
    }
}

