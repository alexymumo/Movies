package com.alexmumo.repository.mappers

import com.alexmumo.cache.entity.Genre
import com.alexmumo.cache.entity.MovieDetails
import com.alexmumo.domain.models.Details
import com.alexmumo.domain.models.Genres

internal fun Details.toEntity(): MovieDetails {
    return MovieDetails(
        this.adult,
        this.backdropPath,
        this.genres?.map { it.toEntity() },
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

internal fun Genres.toEntity(): Genre {
    return Genre(
        this.id,
        this.name
    )
}