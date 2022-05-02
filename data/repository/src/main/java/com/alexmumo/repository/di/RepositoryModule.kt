package com.alexmumo.repository.di

import androidx.paging.ExperimentalPagingApi
import com.alexmumo.repository.datasources.MoviePagingSource
import com.alexmumo.repository.datasources.NowPlayingPagingSource
import com.alexmumo.repository.datasources.TopRatedPagingSource
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
        NowPlayingPagingSource(movieApi = get())
    }
    single {
        TopRatedPagingSource(movieApi = get())
    }
}
