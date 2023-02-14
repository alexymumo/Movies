package com.alexmumo.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_entity")
data class MovieEntity(
    @PrimaryKey
    val movieID: Int,
    val movieImage: String,
    val releaseDate: String,
    val title: String,
    val like: Boolean
    //val overview: String,
    //val popularity: Double,
    //val voteCount: Int
)
