package com.alexmumo.network.api

import com.alexmumo.network.models.PopularMovieDto
import com.alexmumo.network.models.RecommendationsDto
import com.alexmumo.network.models.TopRatedDto
import com.alexmumo.network.models.UpComingMovieDto
import com.alexmumo.network.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("/movie/popular")
    suspend fun fetPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en"
    ): PopularMovieDto

    @GET("/movie/top_rated")
    suspend fun fetTopRatedMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en"
    ): TopRatedDto

    @GET("/movie/upcoming")
    suspend fun fetUpComingMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en"
    ): UpComingMovieDto

    @GET("/movie/{movie_id}/recommendations")
    suspend fun fetchMovieRecommendations(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en"
    ): RecommendationsDto
}
