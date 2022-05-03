package com.alexmumo.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexmumo.cache.dao.MovieDao
import com.alexmumo.cache.entity.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = false
)

abstract class MovieDatabase : RoomDatabase() {
    abstract val movieDao: MovieDao
}
