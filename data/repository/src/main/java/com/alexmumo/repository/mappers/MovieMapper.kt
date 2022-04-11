package com.alexmumo.repository.mappers

import com.alexmumo.domain.models.Movie
import com.alexmumo.network.models.MovieDto

fun MovieDto.toMovie(): Movie {
    return Movie(
        id = id,
        adult = adult,
        backdropPath = backdropPath,
        genreIds = genreIds,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}
