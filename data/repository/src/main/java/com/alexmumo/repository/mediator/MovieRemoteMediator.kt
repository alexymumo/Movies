package com.alexmumo.repository.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.alexmumo.domain.models.Movie

@ExperimentalPagingApi
class MovieRemoteMediator() : RemoteMediator<Int, Movie>() {
    override suspend fun load(loadType: LoadType, state: PagingState<Int, Movie>): MediatorResult {
        TODO("Not yet implemented")
    }
}