package com.alexmumo.cache.entity

data class Recommendations(
    val dates: String,
    val page: Int?,
    val results: List<Movie>?,
    val total_pages: Int?,
    val total_results: Int?
)
