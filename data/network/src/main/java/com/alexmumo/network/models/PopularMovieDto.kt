package com.alexmumo.network.models

import com.google.gson.annotations.SerializedName

data class PopularMovieDto(
    @SerializedName("page")
    val page: Int?,

    @SerializedName("results")
    val results: List<MovieDto>?,

    @SerializedName("total_pages")
    val totalPages: Int?,

    @SerializedName("total_results")
    val totalResults: Int?
)
