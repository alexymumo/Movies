package com.alexmumo.network.responses

import com.alexmumo.network.models.Video

data class VideoResponse(
    val id: Int,
    val results: List<Video>,
)
