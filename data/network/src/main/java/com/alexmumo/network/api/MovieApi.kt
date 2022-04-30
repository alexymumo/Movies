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

    /*
    @GET("/movie/top_rated")
    suspend fun fetchTopRatedMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en"
    ): TopRatedDto

    @GET("/movie/upcoming")
    suspend fun fetchUpComingMovies(
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

     */
}
