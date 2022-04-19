package com.alexmumo.movies.di

import com.alexmumo.movies.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    viewModel {
        HomeViewModel(get())
    }
}
