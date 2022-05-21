package com.alexmumo.movies.ui.screens.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmumo.domain.models.Cast
import com.alexmumo.domain.models.responses.CastResponse
import com.alexmumo.domain.models.responses.MovieDetailResponse
import com.alexmumo.repository.repositories.MovieDetailRepository
import com.alexmumo.repository.util.Resource
import kotlinx.coroutines.launch

class DetailViewModel constructor(
    private val detailRepository: MovieDetailRepository
) : ViewModel() {
    private var _cast = mutableStateOf<List<Cast>>(emptyList())
    val cast: State<List<Cast>> = _cast

    suspend fun fetchMovieDetails(movieId: Int): Resource<MovieDetailResponse> {
        return detailRepository.fetchMovieDetails(movieId)
    }
    fun fetchMovieCasts(movieId: Int): Resource<CastResponse> {
        viewModelScope.launch {
            detailRepository.fetchMovieCast(movieId).also {
                if (it is Resource.Success) {
                    _cast.value = it.data!!.results
                }
            }
        }
    }
}
