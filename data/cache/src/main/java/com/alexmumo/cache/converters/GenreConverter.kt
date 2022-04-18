package com.alexmumo.cache.converters

import androidx.room.TypeConverter
import com.alexmumo.cache.entity.Genre
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreConverter {
    private val gson = Gson()
    @TypeConverter
    fun from(genre: List<Genre>): String? {
        if (genre.isNullOrEmpty()) return null
        val type = object : TypeToken<List<Genre>>() {}.type
        return gson.toJson(genre, type)
    }

    @TypeConverter
    fun to(genreString: String?): List<Genre>? {
        if (genreString.isNullOrEmpty()) return null
        val type = object : TypeToken<List<Genre>>() {}.type
        return gson.fromJson(genreString, type)
    }
}
