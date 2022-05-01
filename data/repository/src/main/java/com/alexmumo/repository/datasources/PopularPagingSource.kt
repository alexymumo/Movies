package com.alexmumo.repository.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alexmumo.network.api.MovieApi
import com.alexmumo.network.models.Movie

class PopularPagingSource constructor(private val movieApi: MovieApi): PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        TODO("Not yet implemented")
    }

}
