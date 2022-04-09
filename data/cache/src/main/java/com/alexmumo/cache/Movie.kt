package com.alexmumo.cache

import androidx.room.PrimaryKey

data class Movie(
    @PrimaryKey(autoGenerate = true)
    val cacheId: Int = 0,

    val adult: Boolean?,

    val backdropPath: String?,

    val genreIds: List<Int>?,

    val id: Int?,

    val originalLanguage: String?,

    val originalTitle: String?,

    val overview: String?,

    val popularity: Double?,

    val posterPath: String?,

    val releaseDate: String?,

    val title: String?,

    val video: Boolean?,

    val voteAverage: Double?,

    val voteCount: Int?,

    val category: String?,

    var Favorite: Boolean = false,

)
