package com.alexmumo.repository.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alexmumo.network.api.MovieApi
import com.alexmumo.network.models.MovieDto
import retrofit2.HttpException
import java.io.IOException

class MoviePagingSource(private val movieApi: MovieApi) : PagingSource<Int, MovieDto>() {
    override fun getRefreshKey(state: PagingState<Int, MovieDto>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDto> {
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
