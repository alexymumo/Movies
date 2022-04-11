package com.alexmumo.repository.di

import com.alexmumo.domain.repositories.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> {

    }
}
