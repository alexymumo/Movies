package com.alexmumo.cache.converters

import androidx.room.TypeConverter
import com.alexmumo.cache.entity.MovieEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromMovie(movie: List<MovieEntity>): String? {
        if (movie.isNullOrEmpty()) return null

        val type = object : TypeToken<List<MovieEntity>?> () {}.type
        return gson.toJson(movie, type)
    }

    @TypeConverter
    fun toMovie(movieString: String?): List<MovieEntity>? {
        if (movieString.isNullOrEmpty()) return null

        val type = object : TypeToken<List<MovieEntity>?> () {}.type
        return gson.fromJson(movieString, type)
    }
}
