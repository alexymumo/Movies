package com.alexmumo.repository.repositories

import com.alexmumo.network.api.MovieApi
import com.alexmumo.network.responses.MovieDetailResponse
import com.alexmumo.repository.util.Resource

class MovieDetailRepository constructor(private val movieApi: MovieApi) {
    suspend fun fetchMovieDetails(movieId: Int): Resource<MovieDetailResponse> {
        val results = try {
            movieApi.fetchMovieDetail(movieId)
        } catch (e: Exception) {
            return Resource.Error("error occured")
        }
        return Resource.Success(results)
    }
}
