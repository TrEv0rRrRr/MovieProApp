package pe.edu.upc.movieproapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import pe.edu.upc.movieproapp.core.ui.theme.AppBookTheme
import pe.edu.upc.movieproapp.features.home.presentation.HomeView

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppBookTheme {
                HomeView(viewModel())
            }
        }
    }
}