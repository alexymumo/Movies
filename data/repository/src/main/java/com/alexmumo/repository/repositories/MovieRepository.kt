package com.alexmumo.repository.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alexmumo.network.api.MovieApi
import com.alexmumo.network.models.Movie
import com.alexmumo.repository.datasources.PopularPagingSource
import com.alexmumo.repository.datasources.NowPlayingPagingSource
import com.alexmumo.repository.datasources.TopRatedPagingSource
import com.alexmumo.repository.datasources.UpcomingPagingSource
import kotlinx.coroutines.flow.Flow

class MovieRepository constructor(private val movieApi: MovieApi) {
    fun fetchPopularMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                enablePlaceholders = true,
                pageSize = 30
            ),
            pagingSourceFactory = {
                PopularPagingSource(movieApi)
            }
        ).flow
    }

    fun fetchNowPlayingMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                enablePlaceholders = true,
                pageSize = 30
            ),
            pagingSourceFactory = {
                NowPlayingPagingSource(movieApi)
            }
        ).flow
    }

    fun fetchTopRatedMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                enablePlaceholders = true,
                pageSize = 30
            ),
            pagingSourceFactory = {
                TopRatedPagingSource(movieApi)
            }
        ).flow
    }
    fun fetchUpcomingMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                enablePlaceholders = true,
                pageSize = 30
            ),
            pagingSourceFactory = {
                UpcomingPagingSource(movieApi)
            }
        ).flow
    }
}
