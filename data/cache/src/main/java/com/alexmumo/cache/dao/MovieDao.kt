package com.alexmumo.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexmumo.cache.entity.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movie: List<Movie>)

    @Query("DELETE FROM movie_entity WHERE category=:category")
    suspend fun deleteMovie(category: String)

    @Query("SELECT * FROM movie_entity WHERE category=:category")
    fun fetchMovies(category: String)

    @Query("SELECT * FROM movie_entity WHERE Favorite=:Favorite")
    fun fetchFavoriteMovies(Favorite: Boolean = true): Flow<List<Movie>>
}
