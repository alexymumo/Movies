package com.alexmumo.cache.entity

data class TopRated(
    val page: Int?,
    val results: List<MovieEntity>?,
    val total_pages: Int?,
    val total_results: Int?
)