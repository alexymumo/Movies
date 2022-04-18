package com.alexmumo.domain.repositories

import androidx.paging.PagingData
import com.alexmumo.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun fetchAllMovies(category: String): Flow<PagingData<Movie>>
}
