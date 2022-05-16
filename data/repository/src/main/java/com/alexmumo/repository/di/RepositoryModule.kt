package com.alexmumo.repository.di

import androidx.paging.ExperimentalPagingApi
import com.alexmumo.repository.datasources.*
import com.alexmumo.repository.repositories.MovieDetailRepository
import com.alexmumo.repository.repositories.MovieRepository
import org.koin.dsl.module

@ExperimentalPagingApi
val repositoryModule = module {
    single {
        PopularPagingSource(movieApi = get())
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
    single {
        MovieDetailRepository(movieApi = get())
    }
    single {
        UpcomingPagingSource(movieApi = get())
    }
    single {
        SearchPagingSource(movieApi = get(), query = get())
    }
}
