package com.alexmumo.network.api

import com.alexmumo.network.responses.MovieResponse
import com.alexmumo.network.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun fetchPopularMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): MovieResponse

    @GET("movie/upcoming")
    suspend fun fetchUpcomingMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): MovieResponse
}
