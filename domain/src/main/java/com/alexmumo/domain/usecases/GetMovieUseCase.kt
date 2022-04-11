package com.alexmumo.domain.usecases

import androidx.paging.PagingData
import com.alexmumo.domain.models.Movie
import com.alexmumo.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovieUseCase constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke() : Flow<PagingData<Movie>> {
        return movieRepository.fetchAllMovies()
    }
}
