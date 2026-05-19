package pe.edu.upc.movieproapp.features.home.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.movieproapp.features.home.presentation.HomeView

@Composable
fun Main() {

    val navController = rememberNavController()

    Scaffold(

        bottomBar = {
            MainBottomBar(navController)
        }

    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = HomeRoute,
            modifier = Modifier.padding(paddingValues)
        ) {

            composable<HomeRoute> {
                HomeView(hiltViewModel())
            }

//            composable<FavoritesRoute> {
//                FavoritesView(viewModel())
//            }
//
//            composable<PopularRoute> {
//                PopularView(viewModel())
//            }
        }
    }
}