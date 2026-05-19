package pe.edu.upc.movieproapp.features.popular.presentation.navigation

import pe.edu.upc.movieproapp.R

enum class MainTab(
    val label: String,
    val id: Int
) {
    Home("Home", id = R.drawable.home),
    Favorites("Favorites", id = R.drawable.favorite),
    Popular("Popular", id = R.drawable.popular),
}