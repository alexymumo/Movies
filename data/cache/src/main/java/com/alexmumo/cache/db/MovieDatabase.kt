package com.alexmumo.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alexmumo.cache.converters.MovieConverter
import com.alexmumo.cache.dao.MovieDao
import com.alexmumo.cache.dao.RemoteKeyDao
import com.alexmumo.cache.entity.MovieDetails
import com.alexmumo.cache.entity.MovieEntity
import com.alexmumo.cache.entity.RemoteKey

@Database(
    entities = [MovieEntity::class, RemoteKey::class, MovieDetails::class],
    version = 1,
    exportSchema = true
)
// fd65c1178171ce0d12871600b495fa47

@TypeConverters(
    MovieConverter::class
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun remoteDao(): RemoteKeyDao
}
