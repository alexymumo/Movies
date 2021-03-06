package com.alexmumo.repository.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alexmumo.domain.models.Movie
import com.alexmumo.network.api.MovieApi
import retrofit2.HttpException
import java.io.IOException

class PopularPagingSource constructor(private val movieApi: MovieApi) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.nextKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage = params.key ?: 1
            val popular = movieApi.fetchPopularMovies(nextPage)
            LoadResult.Page(
                data = popular.results,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (popular.results.isEmpty()) null else popular.page + 1
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }
}
