package com.alexmumo.cache.converters

import androidx.room.TypeConverter
import com.alexmumo.cache.entity.Movie

class MovieConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromMovie(movie: List<Movie>): String? {

    }

    @TypeConverter
    fun toMovie(movieString: String?): List<Movie>? {

    }
}
