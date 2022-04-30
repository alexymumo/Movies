package com.alexmumo.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alexmumo.cache.converters.GenreConverter
import com.alexmumo.cache.converters.GenreIDConverter
import com.alexmumo.cache.converters.MovieConverter
import com.alexmumo.cache.dao.MovieDao
import com.alexmumo.cache.dao.RemoteKeyDao
import com.alexmumo.cache.entity.MovieDetails
import com.alexmumo.cache.entity.MovieEntity
import com.alexmumo.cache.entity.RemoteKey

@Database(
    entities = [MovieEntity::class, RemoteKey::class, MovieDetails::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(
    GenreConverter::class,
    MovieConverter::class,
    GenreIDConverter::class
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun remoteDao(): RemoteKeyDao
}
