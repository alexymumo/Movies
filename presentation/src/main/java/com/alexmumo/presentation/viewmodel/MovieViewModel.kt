package com.alexmumo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.alexmumo.domain.usecases.GetMovieUseCase

class MovieViewModel constructor(private val getMovieUseCase: GetMovieUseCase) : ViewModel()
