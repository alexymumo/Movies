package com.alexmumo.cache.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.alexmumo.cache.entity.MovieEntity

@Dao
interface MovieDao {
    @Insert
    suspend fun saveMovie(movie: MovieEntity)

    @Query("DELETE FROM movie_entity")
    suspend fun deleteMovie()

    @Query("SELECT * FROM movie_entity ORDER BY movieID DESC")
    fun fetchAllMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT `like` FROM movie_entity WHERE movieID == :movieID")
    fun checkFavorite(movieID: Int): LiveData<Boolean>
}
