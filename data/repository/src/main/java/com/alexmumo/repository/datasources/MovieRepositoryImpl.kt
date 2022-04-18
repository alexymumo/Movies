package com.alexmumo.repository.datasources

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alexmumo.cache.db.MovieDatabase
import com.alexmumo.cache.entity.MovieEntity
import com.alexmumo.domain.models.Movie
import com.alexmumo.domain.repositories.MovieRepository
import com.alexmumo.network.api.MovieApi
import com.alexmumo.network.utils.BaseRepository
import com.alexmumo.repository.mediator.MovieRemoteMediator
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class MovieRepositoryImpl constructor(
    private val movieApi: MovieApi,
    private val movieDatabase: MovieDatabase
) : MovieRepository, BaseRepository() {

    private val movieDao = movieDatabase.movieDao()

    override suspend fun fetchAllMovies(category: String): Flow<PagingData<Movie>> {
        val pagingConfig = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false,
            maxSize = 100
        )
        val remoteMediator = MovieRemoteMediator(
            category = category,
            movieApi = movieApi,
            movieDatabase = movieDatabase
        )
    }
    private suspend fun saveMovie(movies: List<MovieEntity>) = movieDao.saveMovie(movies)
}
