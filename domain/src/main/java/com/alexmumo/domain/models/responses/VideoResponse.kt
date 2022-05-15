package com.alexmumo.domain.models.responses

import com.alexmumo.domain.models.Video

data class VideoResponse(
    val id: Int,
    val results: List<Video>,
)
