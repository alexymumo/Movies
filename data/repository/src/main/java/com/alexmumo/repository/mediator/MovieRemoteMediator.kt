package com.alexmumo.repository.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.alexmumo.cache.db.MovieDatabase
import com.alexmumo.domain.models.Movie
import com.alexmumo.network.api.MovieApi

@ExperimentalPagingApi
class MovieRemoteMediator constructor(
    private val category: String,
    private val movieApi: MovieApi,
    private val movieDatabase: MovieDatabase
) : RemoteMediator<Int, Movie>() {

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Movie>): MediatorResult {
        TODO("Not yet implemented")
    }
}
