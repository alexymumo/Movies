package com.alexmumo.network.api

import com.alexmumo.network.responses.MovieDetailResponse
import com.alexmumo.network.responses.MovieResponse
import com.alexmumo.network.responses.SimilarMovieResponse
import com.alexmumo.network.responses.VideoResponse
import com.alexmumo.network.utils.Constants.API_KEY
import com.alexmumo.network.utils.Constants.FIRST_PAGE_INDEX
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun fetchPopularMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): MovieResponse

    @GET("movie/now_playing")
    suspend fun fetchNowPlayingMovies(
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

    @GET("movie/{movie_id}")
    suspend fun fetchMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): MovieDetailResponse

    @GET("movie/top_rated")
    suspend fun fetchTopRated(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): MovieResponse

    @GET("movie/{movie_id}/videos")
    suspend fun fetchMovieTrailer(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): VideoResponse

    @GET("movie/{movie_id}/similar")
    suspend fun fetchSimilarMovies(
        @Query("page") page: Int = FIRST_PAGE_INDEX,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): SimilarMovieResponse
}
