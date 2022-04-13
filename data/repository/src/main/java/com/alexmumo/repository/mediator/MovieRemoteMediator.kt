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
    private val movieDatabase: MovieDatabase,
    private val movieApi: MovieApi
) : RemoteMediator<Int, Movie>() {

    private val remoteKeyDao = movieDatabase.remoteDao()
    private val movieDao = movieDatabase.movieDao()
    override suspend fun load(loadType: LoadType, state: PagingState<Int, Movie>): MediatorResult {
        val pageKey = fetchPagedData(loadType, state)

        val page = when (pageKey) {
            is MediatorResult.Success -> {
                return pageKey
            }
            else -> {
                pageKey as Int
            }
        }

    }

    private fun fetchPagedData(loadType: LoadType, state: PagingState<Int, Movie>): Any {

    }
}

/*Remote Mediator notes
* It helps to load paged data from the network in the database but doesnt load directly from the ui
* App uses database as source of truth(app uses data that is cached in database)
* load() - is responsible for updating the backing dataset and invalidating the PageSource
* load() - has two takes two parameters  >PagingState
*
* Steps performed by load
* -Determine which page to load from the network depending on load type and data loaded so far
* -Trigger the network request
* -Perform actions depending on the outcome of the load operations
* */
