package com.dcht.themoviedb.domain.model

data class CastUI(
    val character: String,
    val id: Int,
    val name: String,
    val originalName: String,
    val profilePath: String?
)
