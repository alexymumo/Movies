package com.alexmumo.movies.ui.screens.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.alexmumo.domain.models.Movie
import com.alexmumo.repository.repositories.MovieSearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class SearchViewModel constructor(
    private val movieSearchRepository: MovieSearchRepository
) : ViewModel() {
    private val _searchString = mutableStateOf("")
    val searchString: State<String> = _searchString

    fun setString(search: String) {
        _searchString.value = search
    }

    private val _search = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val search: State<Flow<PagingData<Movie>>> = _search

    fun searchMoviesByName(searchString: String) {
        viewModelScope.launch {
            _search.value = movieSearchRepository.searchMovies(searchString).map { pagingData ->
                pagingData.filter {
                    ((it.title != null || it.originalTitle != null))
                }
            }.cachedIn(viewModelScope)
        }
    }
}
