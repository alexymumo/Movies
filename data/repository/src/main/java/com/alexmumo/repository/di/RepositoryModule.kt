package com.alexmumo.repository.di

import androidx.paging.ExperimentalPagingApi
import com.alexmumo.repository.datasources.MoviePagingSource
import com.alexmumo.repository.repositories.MovieRepository
import org.koin.dsl.module

@ExperimentalPagingApi
val repositoryModule = module {
    single {
        MoviePagingSource(movieApi = get())
    }
    single {
        MovieRepository(movieApi = get())
    }
    single {
        MovieRepository(movieApi = get())
    }
}
