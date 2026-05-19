package pe.edu.upc.movieproapp.features.popular.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@Composable
fun MainBottomBar(navController: NavController) {
    NavigationBar() {
        MainTab.entries.forEach { tab ->
            NavigationBarItem(
                selected = false,
                onClick = {
                    when(tab) {
                        MainTab.Home -> navController.navigate(HomeRoute)
                        MainTab.Favorites -> navController.navigate(FavoritesRoute)
                        MainTab.Popular -> navController.navigate(PopularRoute)
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(tab.id),
                        contentDescription = tab.label
                    )
                },
                label = { Text(tab.label) }
            )
        }
    }
}