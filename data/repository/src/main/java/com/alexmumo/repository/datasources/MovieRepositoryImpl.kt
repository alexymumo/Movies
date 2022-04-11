package com.alexmumo.repository.datasources

import androidx.paging.* // ktlint-disable no-wildcard-imports
import com.alexmumo.domain.models.Movie
import com.alexmumo.domain.repositories.MovieRepository
import com.alexmumo.network.api.MovieApi
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl constructor(private val movieApi: MovieApi) : MovieRepository {
    override suspend fun fetchAllMovies(): Flow<PagingData<Movie>> {
        return Pager(PagingConfig(pageSize = 20)) {
            MoviePagingSource(movieApi = movieApi)
        }.flow
    }
}

class MoviePagingSource(private val movieApi: MovieApi) : PagingSource<Int, Movie> () {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorposition ->
            state.closestPageToPosition(anchorposition)?.prevKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val pageNo = params.key ?: 1
        return try {

        } catch (e: Exception) {
            LoadResult.Error(e)

        }
    }
}
