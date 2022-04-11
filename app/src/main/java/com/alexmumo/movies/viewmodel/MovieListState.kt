package com.alexmumo.movies.viewmodel

import androidx.paging.PagingData
import com.alexmumo.domain.models.Movie
import kotlinx.coroutines.flow.Flow

data class MovieListState(
    var isLoading: Boolean = false,
    val movieList: Flow<PagingData<Movie>>? = null,
    val errorMessage: String = ""
)
