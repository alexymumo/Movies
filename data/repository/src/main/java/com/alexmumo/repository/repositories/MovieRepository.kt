package com.alexmumo.repository.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alexmumo.network.api.MovieApi
import com.alexmumo.repository.datasources.MoviePagingSource
import kotlinx.coroutines.flow.Flow

class MovieRepository constructor(private val movieApi: MovieApi) {
    fun fetchPopularMovies(): Flow<PagingData<com.alexmumo.network.models.Movie>> {
        return Pager(
            config = PagingConfig(
                enablePlaceholders = false,
                pageSize = 20
            ),
            pagingSourceFactory = {
                MoviePagingSource(movieApi)
            }
        ).flow
    }

    fun fetchUpComingMovies(): Flow<PagingData<com.alexmumo.network.models.Movie>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                MoviePagingSource(movieApi)
            }
        ).flow
    }
}
