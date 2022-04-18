package com.alexmumo.domain.models

data class UpComingMovies(
    val page: Int?,

    val movies: List<Movie>?,

    val totalPages: Int?,

    val totalResults: Int?
)
