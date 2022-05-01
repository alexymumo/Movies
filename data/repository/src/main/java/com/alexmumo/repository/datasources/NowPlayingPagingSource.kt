package com.alexmumo.repository.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alexmumo.network.api.MovieApi
import com.alexmumo.network.models.Movie
import retrofit2.HttpException
import java.io.IOException

class NowPlayingPagingSource constructor(private val movieApi: MovieApi) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage = params.key ?: 1
            val now = movieApi.fetchUpcomingMovies(nextPage)
            val prevKey = if (nextPage > 0) nextPage - 1 else null
            LoadResult.Page(
                data = now.results,
                prevKey = prevKey,
                nextKey = if (now.results.isEmpty()) now.page + 1 else null
            )

        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}
