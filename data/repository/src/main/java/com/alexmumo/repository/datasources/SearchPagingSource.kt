package com.alexmumo.repository.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alexmumo.domain.models.Movie
import com.alexmumo.network.api.MovieApi
import retrofit2.HttpException
import java.io.IOException

class SearchPagingSource(
    private val query: String,
    private val movieApi: MovieApi
) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage = params.key ?: 1
            val search = movieApi.searchMovies(nextPage, query)
            LoadResult.Page(
                data = search.results,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (search.results.isEmpty()) null else search.page + 1
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }
}
