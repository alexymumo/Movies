package com.alexmumo.movies

import android.app.Application
import androidx.paging.ExperimentalPagingApi
import com.alexmumo.domain.di.domainModule
import com.alexmumo.movies.di.presentationModule
import com.alexmumo.network.di.networkModule
import com.alexmumo.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@ExperimentalPagingApi
class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = listOf(networkModule, repositoryModule, domainModule, presentationModule)
        startKoin {
            androidLogger(level = Level.NONE)
            androidContext(this@MovieApplication)
            modules(modules)
        }
    }
}
