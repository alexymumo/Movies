package com.alexmumo.movies.ui.screens.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmumo.cache.entity.MovieEntity
import com.alexmumo.repository.repositories.MovieEntityRepository
import kotlinx.coroutines.launch

class FavoriteViewModel constructor(private val movieEntityRepository: MovieEntityRepository) : ViewModel() {
    fun saveMovie(movieEntity: MovieEntity) {
        viewModelScope.launch {
            movieEntityRepository.saveMovie(movieEntity)
        }
    }
}
