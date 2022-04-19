package com.alexmumo.repository.di

import androidx.paging.ExperimentalPagingApi
import com.alexmumo.domain.repositories.MovieRepository
import com.alexmumo.repository.datasources.MovieRepositoryImpl
import org.koin.dsl.module

@ExperimentalPagingApi
val repositoryModule = module {
    single<MovieRepository> {
        MovieRepositoryImpl(movieApi = get(), movieDatabase = get())
    }
}
