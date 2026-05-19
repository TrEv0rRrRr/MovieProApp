package pe.edu.upc.movieproapp.features.popular.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pe.edu.upc.movieproapp.features.favorites.presentation.FavoriteView
import pe.edu.upc.movieproapp.features.home.presentation.HomeView
import pe.edu.upc.movieproapp.features.popular.presentation.PopularView

@Composable
fun AppNavigation(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {

        composable<HomeRoute> {
            HomeView()
        }
    }
}