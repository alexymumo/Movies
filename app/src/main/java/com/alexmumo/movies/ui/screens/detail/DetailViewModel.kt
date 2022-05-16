package com.alexmumo.movies.ui.screens.detail

import androidx.lifecycle.ViewModel
import com.alexmumo.domain.models.responses.MovieDetailResponse
import com.alexmumo.repository.repositories.MovieDetailRepository
import com.alexmumo.repository.util.Resource

class DetailViewModel constructor(
    private val detailRepository: MovieDetailRepository
) : ViewModel() {
    suspend fun fetchMovieDetails(movieId: Int): Resource<MovieDetailResponse> {
        return detailRepository.fetchMovieDetails(movieId)
    }
}
