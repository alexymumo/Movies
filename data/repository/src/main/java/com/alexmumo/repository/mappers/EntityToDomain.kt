package com.alexmumo.repository.mappers

import com.alexmumo.cache.entity.*
import com.alexmumo.domain.models.*

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

internal fun MovieDetails.toDomain(): Details {
    return Details(
        this.adult,
        this.backdropPath,
        this.genres?.map { it.toDomain() },
        this.homepage,
        this.id,
        this.imdbId,
        this.originalLanguage,
        this.originalTitle,
        this.overview,
        this.popularity,
        this.posterPath,
        this.releaseDate,
        this.runtime,
        this.status,
        this.tagline,
        this.title,
        this.video,
        this.voteAverage,
        this.voteCount
    )
}

internal fun Popular.toDomain(): PopularMovies {
    return PopularMovies(
        this.page,
        this.results?.map { it.toDomain() },
        this.total_pages,
        this.total_results,
    )
}
