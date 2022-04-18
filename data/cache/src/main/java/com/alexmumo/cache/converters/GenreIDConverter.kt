package com.alexmumo.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreIDConverter {
    private val json = Gson()
    @TypeConverter
    fun from(genre: List<Int>): String? {
        if (genre.isNullOrEmpty()) return null
        val type = object : TypeToken<List<Int>>() {}.type
        return json.toJson(genre , type)
    }
    @TypeConverter
    fun to(genreString: String?) : List<Int>? {
        if (genreString.isNullOrEmpty()) return null

        val  type = object : TypeToken<List<Int>>() {}.type
        return json.fromJson(genreString, type)
    }
}