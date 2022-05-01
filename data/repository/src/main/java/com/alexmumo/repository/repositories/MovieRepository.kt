package com.alexmumo.repository.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alexmumo.network.api.MovieApi
import com.alexmumo.network.models.Movie
import com.alexmumo.repository.datasources.MoviePagingSource
import com.alexmumo.repository.datasources.NowPlayingPagingSource
import kotlinx.coroutines.flow.Flow

class MovieRepository constructor(private val movieApi: MovieApi) {
    fun fetchPopularMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                enablePlaceholders = true,
                pageSize = 20
            ),
            pagingSourceFactory = {
                MoviePagingSource(movieApi)
            }
        ).flow
    }

    fun fetchNowPlayingMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                enablePlaceholders = false,
                pageSize = 20
            ),
            pagingSourceFactory = {
                NowPlayingPagingSource(movieApi)
            }
        ).flow
    }
}
