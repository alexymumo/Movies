package com.alexmumo.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexmumo.cache.entity.MovieDetails
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDetailDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveMovieDetails(movieDetails: MovieDetails)

    @Query("SELECT *FROM movie_detail WHERE id=:movieId")
    fun fetchMovieDetails(): Flow<MovieDetails>
}
