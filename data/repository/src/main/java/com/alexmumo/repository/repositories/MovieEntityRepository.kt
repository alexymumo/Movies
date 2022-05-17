package com.alexmumo.repository.repositories

import androidx.lifecycle.LiveData
import com.alexmumo.cache.db.MovieDatabase
import com.alexmumo.cache.entity.MovieEntity

class MovieEntityRepository constructor(private val movieDatabase: MovieDatabase) {
    suspend fun saveMovie(movie: MovieEntity) {
        movieDatabase.movieDao.saveMovie(movie)
    }
    fun fetchAllMovies(): LiveData<List<MovieEntity>> {
        return movieDatabase.movieDao.fetchAllMovies()
    }
    fun checkFavorite(movieID: Int): LiveData<Boolean> {
        return movieDatabase.movieDao.checkFavorite(movieID)
    }
}
