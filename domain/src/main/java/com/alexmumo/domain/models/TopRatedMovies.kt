package com.alexmumo.domain.models

data class TopRatedMovies(
    val page: Int?,

    val movies: List<Movie>?,

    val totalPages: Int?,

    val totalResults: Int?
)
