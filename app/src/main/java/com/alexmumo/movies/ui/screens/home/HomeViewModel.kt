package com.alexmumo.movies.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.alexmumo.network.models.MovieDto
import com.alexmumo.repository.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeViewModel constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private var _popularMovies = mutableStateOf<Flow<PagingData<MovieDto>>>(emptyFlow())
    val popular: State<Flow<PagingData<MovieDto>>> = _popularMovies
    init {
        fetchPopularMovies(null)
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
