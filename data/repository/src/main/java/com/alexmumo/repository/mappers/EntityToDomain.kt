package com.alexmumo.repository.mappers

import com.alexmumo.cache.entity.Dates
import com.alexmumo.cache.entity.Genre
import com.alexmumo.cache.entity.MovieEntity
import com.alexmumo.domain.models.Date
import com.alexmumo.domain.models.Genres
import com.alexmumo.domain.models.Movie

internal fun MovieEntity.toDomain(): Movie {
    return Movie(
        this.adult,
        this.backdropPath,
        this.genreIds,
        this.cacheId,
        this.originalLanguage,
        this.originalTitle,
        this.overview,
        this.popularity,
        this.posterPath,
        this.releaseDate,
        this.title,
        this.video,
        this.voteAverage,
        this.voteCount,
        category = null,
        isFavorite = null,
        this.cacheId
    )
}

internal fun Dates.toDomain(): Date {
    return Date(
        this.maximum,
        this.minimum
    )
}

internal fun Genre.toDomain(): Genres {
    return Genres(
        this.id,
        this.name
    )
}

