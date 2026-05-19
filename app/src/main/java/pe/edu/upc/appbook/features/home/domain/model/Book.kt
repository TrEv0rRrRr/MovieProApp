package pe.edu.upc.appbook.features.home.domain.model

import java.util.Date

data class Book(
    val author: String,
    val title: String,
    val url: String,
    val publishedAt: Date,
    val content: String,
    val urlToImage: String,
    val isFavorite: Boolean
)
