package com.alexmumo.repository.repositories

import androidx.paging.Pager
import androidx.paging.PagingData
import com.alexmumo.domain.models.Movie
import com.alexmumo.network.api.MovieApi
import kotlinx.coroutines.flow.Flow

class MovieRepository(private val movieApi: MovieApi) {
    fun fetchPopularMovies(): Flow<PagingData<Movie>> {
        return Pager(

        )
    }
}
