package com.alexmumo.network.api

import com.alexmumo.network.models.PopularMovieDto
import com.alexmumo.network.models.UpComingMovieDto
import com.alexmumo.network.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en"
    ): PopularMovieDto

    @GET("/movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    )

    @GET("/movie/upcoming")
    suspend fun getUpComingMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): UpComingMovieDto
}
