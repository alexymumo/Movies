package com.alexmumo.network.responses

import com.alexmumo.network.models.Movie
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
