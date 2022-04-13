package com.alexmumo.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexmumo.cache.entity.RemoteKey

@Dao
interface RemoteKeyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveRemoteKey(remoteKey: List<RemoteKey>)

    @Query("SELECT * FROM remote_key WHERE movie_id=:movie_id")
    suspend fun fetchRemoteKey(movie_id: Int): RemoteKey
}
