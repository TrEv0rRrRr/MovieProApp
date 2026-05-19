package pe.edu.upc.movieproapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import pe.edu.upc.movieproapp.core.ui.theme.MovieProAppTheme
import pe.edu.upc.movieproapp.features.popular.presentation.navigation.Main

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieProAppTheme {
                Main()
            }
        }
    }
}