package com.alexmumo.movies.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.alexmumo.network.models.Movie
import com.alexmumo.repository.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeViewModel constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private var _popularMovies = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val popular: State<Flow<PagingData<Movie>>> = _popularMovies

    private var _nowplaying = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val nowplaying: State<Flow<PagingData<Movie>>> = _nowplaying

    private var _toprated = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val toprated: State<Flow<PagingData<Movie>>> = _toprated
    init {
        fetchPopularMovies(null)
        fetchNowPlayingMovies(null)
        fetchTopRatedMovies(null)
    }

    private fun fetchTopRatedMovies(genreId: Int?) {
        viewModelScope.launch {
            _toprated.value = if (genreId != null) {
                movieRepository.fetchTopRatedMovies().map { pagingData ->
                    pagingData.filter {
                        it.genreIds.contains(genreId)
                    }
                }.cachedIn(viewModelScope)
            } else {
                movieRepository.fetchTopRatedMovies().cachedIn(viewModelScope)
            }
        }
    }

    private fun fetchNowPlayingMovies(genreId: Int?) {
        viewModelScope.launch {
            _nowplaying.value = if (genreId != null) {
                movieRepository.fetchTopRatedMovies().map { pagingData ->
                    pagingData.filter {
                        it.genreIds.contains(genreId)
                    }
                }.cachedIn(viewModelScope)
            } else {
                movieRepository.fetchNowPlayingMovies().cachedIn(viewModelScope)
            }
        }
    }

    private fun fetchPopularMovies(genreId: Int?) {
        viewModelScope.launch {
            _popularMovies.value = if (genreId != null) {
                movieRepository.fetchPopularMovies().map { pagingData ->
                    pagingData.filter {
                        it.genreIds.contains(genreId)
                    }
                }.cachedIn(viewModelScope)
            } else {
                movieRepository.fetchPopularMovies().cachedIn(viewModelScope)
            }
        }
    }
}
