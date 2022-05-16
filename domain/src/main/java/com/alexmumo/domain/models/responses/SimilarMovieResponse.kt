package com.alexmumo.domain.models.responses

import com.alexmumo.domain.models.Movie
import com.google.gson.annotations.SerializedName

data class SimilarMovieResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
