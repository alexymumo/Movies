package com.alexmumo.repository.repositories

import com.alexmumo.cache.db.MovieDatabase
import com.alexmumo.cache.entity.MovieEntity

class MovieEntityRepository constructor(private val movieDatabase: MovieDatabase) {
    suspend fun saveMovie(movie: MovieEntity) {
        movieDatabase.movieDao.saveMovie(movie)
    }
}
