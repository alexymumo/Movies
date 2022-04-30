package com.alexmumo.repository.datasources

/*
@ExperimentalPagingApi
class MovieRepositoryImpl constructor(
    private val movieApi: MovieApi,
    private val movieDatabase: MovieDatabase
) : MovieRepository, BaseRepository() {
    private val movieDao = movieDatabase.movieDao()
    private val _movie = MutableLiveData<List<MovieEntity>>()

    init {
        _movie.observeForever { movies ->
            CoroutineScope(Dispatchers.IO).launch {
                movieDao.saveMovie(movies)
            }
        }
    }

    private suspend fun saveMovie(movies: List<MovieEntity>) = movieDao.saveMovie(movies)

    override suspend fun fetchAllMovies(category: String): Flow<PagingData<Movie>> {
        val pagingConfig = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false,
            maxSize = 10
        )
        val remoteMediator = MovieRemoteMediator(
            category = category,
            movieApi = movieApi,
            movieDatabase = movieDatabase
        )
        val pagingSource = {
            movieDao.pagingSource(
                category = category
            )
        }

        return Pager(
            config = pagingConfig,
            remoteMediator = remoteMediator,
            pagingSourceFactory = pagingSource
        ).flow
    }

    suspend fun fetchNowPlayingMovies(category: String): Flow<PagingData<Movie>> {
        TODO("")
    }
}

 */

