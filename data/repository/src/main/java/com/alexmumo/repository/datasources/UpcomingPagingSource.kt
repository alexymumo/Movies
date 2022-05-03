package com.alexmumo.repository.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alexmumo.network.api.MovieApi
import com.alexmumo.network.models.Movie
import retrofit2.HttpException
import java.io.IOException

class UpcomingPagingSource constructor(private val movieApi: MovieApi) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage = params.key ?: 1
            val upcoming = movieApi.fetchUpcomingMovies(nextPage)
            LoadResult.Page(
                data = upcoming.results,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (upcoming.results.isEmpty()) null else upcoming.page + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}
