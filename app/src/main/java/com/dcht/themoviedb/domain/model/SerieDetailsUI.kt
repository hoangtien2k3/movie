package com.dcht.themoviedb.domain.model

import com.dcht.themoviedb.data.model.remote.genres.Genre

data class SerieDetailsUI(
    val backdropPath: String,
    val genres: List<Genre>,
    val id: Int,
    val name: String,
    val firstAirDate: String,
    val numberOfSeasons: Int,
    val originalLanguage: String,
    val originalName: String,
    val overview: String,
    val posterPath: String,
    val tagline: String,
    val voteAverage: Double,
    val homepage: String
)

