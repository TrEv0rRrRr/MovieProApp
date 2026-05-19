package pe.edu.upc.movieproapp.features.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.movieproapp.features.home.domain.model.Movie

@Composable
fun MovieItem(movie: Movie) {
    val imageUrl = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
    Card(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        Column {
            AsyncImage(
                model = imageUrl,
                contentDescription = movie.title,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = movie.title,
                modifier = Modifier.padding(8.dp),
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}