package com.alexmumo.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexmumo.cache.dao.MovieDao
import com.alexmumo.cache.entity.Movie

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = true
)

abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
