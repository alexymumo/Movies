package com.alexmumo.repository.datasources

import androidx.lifecycle.MutableLiveData
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alexmumo.cache.db.MovieDatabase
import com.alexmumo.cache.entity.MovieEntity
import com.alexmumo.domain.models.Movie
import com.alexmumo.domain.repositories.MovieRepository
import com.alexmumo.network.api.MovieApi
import com.alexmumo.network.utils.BaseRepository
import com.alexmumo.repository.mediator.MovieRemoteMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@ExperimentalPagingApi
class MovieRepositoryImpl constructor(
    private val movieApi: MovieApi,
    private val movieDatabase: MovieDatabase
) : MovieRepository, BaseRepository() {
    private val movieDao = movieDatabase.movieDao()
    private val _movie = MutableLiveData<List<MovieEntity>>()

    init {
        _movie.observeForever { movies ->
            CoroutineScope(Dispatchers.IO).launch {
                movieDao.saveMovie(movies)
            }
        }
    }

    private suspend fun saveMovie(movies: List<MovieEntity>) = movieDao.saveMovie(movies)

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
        val pagingSource = {
            movieDao.pagingSource(category = category)
        }

        return Pager(
            config = pagingConfig,
            remoteMediator = remoteMediator,
            pagingSourceFactory = pagingSource
        ).flow
    }
}

