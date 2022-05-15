package com.alexmumo.repository.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alexmumo.domain.models.Movie
import com.alexmumo.network.api.MovieApi
import com.alexmumo.repository.datasources.SearchPagingSource
import kotlinx.coroutines.flow.Flow

class MovieSearchRepository constructor(private val movieApi: MovieApi) {
    fun searchMovies(searchString: String): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 30),
            pagingSourceFactory = {
                SearchPagingSource(searchString, movieApi)
            }
        ).flow
    }
}
