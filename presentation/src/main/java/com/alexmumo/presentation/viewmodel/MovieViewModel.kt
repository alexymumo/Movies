package com.alexmumo.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.alexmumo.domain.usecases.GetMovieUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class MovieViewModel constructor(private val movieUseCase: GetMovieUseCase) : ViewModel() {
    private val _state: MutableState<MovieListState> = mutableStateOf(MovieListState())
    private val handler = CoroutineExceptionHandler { _, exception ->
        _state.value.isLoading = false
        _state.value = MovieListState(errorMessage = exception.message!!)
    }
    val movieListState get() = _state

    init {
        fetchMovies()
    }

    private fun fetchMovies() = viewModelScope.launch(handler) {
        val movieResponse = movieUseCase().cachedIn(viewModelScope)
        _state.value = MovieListState(movieList = movieResponse)
    }
}
