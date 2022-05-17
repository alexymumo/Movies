package com.alexmumo.cache.di

import androidx.room.Room
import com.alexmumo.cache.db.MovieDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val cacheModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            MovieDatabase::class.java,
            "movie.db"
        ).fallbackToDestructiveMigration().build()
    }
}
