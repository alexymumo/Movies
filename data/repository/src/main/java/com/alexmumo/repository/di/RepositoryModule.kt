package com.alexmumo.repository.di

import androidx.paging.ExperimentalPagingApi
import com.alexmumo.repository.datasources.MovieRepositoryImpl
import com.alexmumo.repository.repositories.MovieRepository
import org.koin.dsl.module

@ExperimentalPagingApi
val repositoryModule = module {
    single<MovieRepository> { MovieRepositoryImpl(movieApi = get(), movieDatabase = get()) }
}
