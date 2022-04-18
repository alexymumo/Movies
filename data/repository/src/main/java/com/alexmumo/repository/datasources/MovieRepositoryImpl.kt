package com.alexmumo.repository.datasources

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alexmumo.cache.db.MovieDatabase
import com.alexmumo.cache.entity.MovieEntity
import com.alexmumo.domain.models.Movie
import com.alexmumo.domain.repositories.MovieRepository
import com.alexmumo.network.api.MovieApi
import com.alexmumo.network.utils.BaseRepository
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl constructor(
    private val movieApi: MovieApi,
    private val movieDatabase: MovieDatabase
) : MovieRepository, BaseRepository() {

    private val movieDao = movieDatabase.movieDao()
    override suspend fun fetchAllMovies(): Flow<PagingData<Movie>> {
        val pagingConfig = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false,
            maxSize = 100
        )
        val remoteMediator =
    }
    private suspend fun saveMovie(movies: List<MovieEntity>) = movieDao.saveMovie(movies)
}
