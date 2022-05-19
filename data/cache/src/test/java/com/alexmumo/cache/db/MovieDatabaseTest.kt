package com.alexmumo.cache.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.alexmumo.cache.dao.MovieDao
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class MovieDatabaseTest : TestCase() {
    private lateinit var movieDao: MovieDao
    private lateinit var movieDatabase: MovieDatabase

    @Before
    public override fun setUp() {
        val content = ApplicationProvider.getApplicationContext<Context>()
        movieDatabase = Room.inMemoryDatabaseBuilder(
            content,
            MovieDatabase::class.java
        ).build()
        movieDao = movieDatabase.movieDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        movieDatabase.close()
    }
}
