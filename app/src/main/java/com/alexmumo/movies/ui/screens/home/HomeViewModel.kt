package com.alexmumo.movies.ui.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.alexmumo.domain.models.Movie
import com.alexmumo.repository.repositories.MovieRepository
import com.alexmumo.repository.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

class HomeViewModel constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private val _popularMovies = MutableLiveData<Flow<PagingData<Movie>>>()
    val popularMovies: LiveData<Flow<PagingData<Movie>>> get() = _popularMovies

    init {
        fetchPopularMovies()
    }

    private fun fetchPopularMovies() = viewModelScope.launch {
        try {
            _popularMovies.value = movieRepository.fetchAllMovies(category = Constants.POPULAR_MOVIES)
        } catch (e: Exception) {
            Timber.e("Error occurred")
        }
    }
}
