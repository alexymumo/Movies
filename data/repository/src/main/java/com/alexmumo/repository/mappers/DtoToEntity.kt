package com.alexmumo.repository.mappers

import com.alexmumo.cache.entity.Dates
import com.alexmumo.cache.entity.MovieEntity
import com.alexmumo.cache.entity.Popular
import com.alexmumo.network.models.DatesDto
import com.alexmumo.network.models.MovieDto
import com.alexmumo.network.models.PopularMovieDto

internal fun MovieDto.toEntity(category: String? = null): MovieEntity {
    return MovieEntity(
        this.adult,
        this.backdropPath,
        this.genreIds,
        this.id,
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
        category = category,
        isFavorite = false
    )
}
internal fun DatesDto.toEntity(): Dates {
    return Dates(
        this.maximum,
        this.minimum
    )
}

internal fun PopularMovieDto.toEntity(): Popular {
    return Popular(
        this.page,
        this.results?.map { it.toEntity() },
        this.totalPages,
        this.totalResults
    )
}

