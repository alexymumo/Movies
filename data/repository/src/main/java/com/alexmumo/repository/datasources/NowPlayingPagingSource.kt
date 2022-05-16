package com.alexmumo.repository.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alexmumo.domain.models.Movie
import com.alexmumo.network.api.MovieApi
import retrofit2.HttpException
import java.io.IOException

class NowPlayingPagingSource constructor(private val movieApi: MovieApi) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage = params.key ?: 1
            val now_playing = movieApi.fetchNowPlayingMovies(nextPage)
            LoadResult.Page(
                data = now_playing.results,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (now_playing.results.isEmpty()) null else now_playing.page + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}
