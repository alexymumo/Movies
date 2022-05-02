package com.alexmumo.movies.di

import com.alexmumo.movies.ui.screens.detail.DetailViewModel
import com.alexmumo.movies.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}
