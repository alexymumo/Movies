package com.alexmumo.repository.repositories

import com.alexmumo.domain.models.responses.CastResponse
import com.alexmumo.domain.models.responses.MovieDetailResponse
import com.alexmumo.network.api.MovieApi
import com.alexmumo.repository.util.Resource

class MovieDetailRepository constructor(private val movieApi: MovieApi) {

    suspend fun fetchMovieCast(movieId: Int): Resource<CastResponse> {
        val cast = try {
            movieApi.fetchMovieCast(movieId)
        } catch (e: Exception) {
            return Resource.Error("Failed to fetch cast")
        }
        return Resource.Success(cast)
    }
    suspend fun fetchMovieDetails(movieId: Int): Resource<MovieDetailResponse> {
        val results = try {
            movieApi.fetchMovieDetail(movieId)
        } catch (e: Exception) {
            return Resource.Error("Failed to fetch details")
        }
        return Resource.Success(results)
    }
}
