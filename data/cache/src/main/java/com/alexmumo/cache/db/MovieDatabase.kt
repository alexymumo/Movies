package com.alexmumo.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alexmumo.cache.converters.MovieConverter
import com.alexmumo.cache.dao.MovieDao
import com.alexmumo.cache.entity.Movie

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = true
)
// fd65c1178171ce0d12871600b495fa47

@TypeConverters(
    MovieConverter::class
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
