package com.alexmumo.repository.mediator

/*
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.alexmumo.cache.db.MovieDatabase
import com.alexmumo.cache.entity.RemoteKey
import com.alexmumo.domain.models.Movie
import com.alexmumo.network.api.MovieApi
import retrofit2.HttpException
import java.io.IOException

@ExperimentalPagingApi
class MovieRemoteMediator(
    private val category: String,
    private val movieApi: MovieApi,
    private val movieDatabase: MovieDatabase
) : RemoteMediator<Int, Movie>() {

    private val remoteDao = movieDatabase.remoteDao()
    private val movieDao = movieDatabase.movieDao()


    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Movie>
    ): MediatorResult {
        val page: Int = when(loadType) {

            LoadType.REFRESH -> {
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1)?: 1
            }
            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                val prevKey = remoteKeys?.prevKey
                    ?: return MediatorResult.Success(endOfPaginationReached = true)
                prevKey
            }
            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                val nextKey = remoteKeys?.nextKey
                ?: return MediatorResult.Success(endOfPaginationReached = true)
                nextKey
            }
        }
        try {
            val response = movieApi.fetchPopularMovies(page = page)
            val movies = response.results

            movieDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    remoteDao.deleteRemoteKey()
                    movieDao.deleteMovie(category = category)
                }
                val keys = movies.map {

                }
                movieDatabase.remoteDao().saveRemoteKey()

            }
            return MediatorResult.Success(endOfPaginationReached = true)

        } catch (exception: IOException) {
            return MediatorResult.Error(exception)

        } catch (exception: HttpException) {
            return MediatorResult.Error(exception)

        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, Movie>): RemoteKey? {
        return state.pages.firstOrNull { it.data.isNullOrEmpty() }?.data?.firstOrNull()
            ?.let { movie ->
                movieDatabase.remoteDao().fetchRemoteKey(movie_id = movie.id!!)
            }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, Movie>): RemoteKey? {
        return state.pages.lastOrNull { it.data.isNullOrEmpty() }?.data?.lastOrNull()
            ?.let { movie ->
                movieDatabase.remoteDao().fetchRemoteKey(movie_id = movie.id!!)
            }

    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, Movie>): RemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.let { movie ->
                movieDatabase.remoteDao().fetchRemoteKey(movie_id = movie.id!!)
            }
        }
    }
}

 */

/*
  *
  * PagingState -> contains information about the pages loaded, most recently accessed index and PagingConfig object
  * LoadType -> indicates the load type REFRESH, APPEND, PREPEND
  * load() performs the following steps
  * 1. Determine which page to load from the network depending on the load type
  * 2. Trigger network request
  * 3. Perform actions depending on the outcome of the load operations
  *
  * */

/*
* PAGE FROM NETWORK AND DATABASE
* RemoteMediator acts as signal from the paging from
* the paging library when the app has run out of cached data
* The signal can be used to load additional data from the network and store it in
* the local database where PagingSource can load it and provide it to the UI for display
* When additional data is needed Paging library calls the load() method f
* LoadType informs the the RemoteMediator whether it needs to refresh the existing data
* or fetch additional data that needs to be appended or prepended to existing list
* PagingSource implementation is passed to the Pager through pagingSourceFactory parameter
* As new data is required by the UI the Pager calls the load() from PagingSource and return
* stream of PagingData objects that encapsulates the new data
* Each PagingData object is cached in the ViewModel before being sent to the UI
* RemoteMediator changes the data flow
* If data is exhausted Paging triggers the RemoteMediator to load new data from network
* RemoteMediator stores the new data in the local database
* load() - responsible for updating the backing dataset and invalidating the PagingSource
*
* */
