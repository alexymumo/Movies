package com.alexmumo.cache.entity

data class NowPlaying(
    val page: Int?,
    val results: List<MovieEntity>?,
    val dates: Dates?,
    val total_pages: Int?,
    val total_results: Int?
)
