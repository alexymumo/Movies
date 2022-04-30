package com.alexmumo.cache.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexmumo.cache.entity.MovieEntity
import com.alexmumo.cache.utils.Constants
import com.alexmumo.domain.models.Movie
import kotlinx.coroutines.flow.Flow

/*
* query cached movies
* */
@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movie: List<MovieEntity>)

    @Query("DELETE FROM movie_entity WHERE category=:category")
    suspend fun deleteMovie(category: String)

    @Query("SELECT * FROM movie_entity WHERE category=:category")
    fun pagingSource(category: String): PagingSource<Int, Movie>

    @Query("SELECT * FROM movie_entity WHERE isFavorite=:Favorite")
    fun fetchFavoriteMovies(Favorite: Boolean = true): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie_entity WHERE category=:category")
    fun fetchNowPlaying(category: String = Constants.TOP_RATED_MOVIES)
}
