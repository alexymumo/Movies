package com.alexmumo.domain.di

import com.alexmumo.domain.usecases.GetMovieUseCase
import org.koin.dsl.module

val domainModule = module {
    single {
        GetMovieUseCase(get())
    }
}
