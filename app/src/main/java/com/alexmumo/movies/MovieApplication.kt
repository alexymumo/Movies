package com.alexmumo.movies

import android.app.Application
import androidx.paging.ExperimentalPagingApi
import com.alexmumo.cache.di.cacheModule
import com.alexmumo.movies.di.presentationModule
import com.alexmumo.network.di.networkModule
import com.alexmumo.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

@ExperimentalPagingApi
class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        initTimber()
    }

    private fun initTimber() {
    }

    private fun initKoin() {
        val modules = listOf(networkModule, repositoryModule, presentationModule, cacheModule)
        startKoin {
            androidLogger(level = Level.NONE)
            androidContext(this@MovieApplication)
            modules(modules)
        }
    }
}
