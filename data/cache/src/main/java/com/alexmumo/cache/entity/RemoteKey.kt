package com.alexmumo.cache.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_key")
data class RemoteKey(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "movie_id")
    val movie_id: Int,

    @ColumnInfo(name = "nextKey")
    val nextKey: Int? = null,

    @ColumnInfo(name = "prevKey")
    val prevKey: Int? = null
)
