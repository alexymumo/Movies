package com.alexmumo.network.api

import com.alexmumo.network.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en"
    )

    @GET("/movie/latest")
    suspend fun getLatestMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    )

    @GET("/movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    )

    @GET("/movie/upcoming")
    suspend fun getUpComingMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    )
}
