package com.alexmumo.domain.models.responses

import com.alexmumo.domain.models.Cast
import com.google.gson.annotations.SerializedName

data class CastResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<Cast>,
)
