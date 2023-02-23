package com.veo.codechallenge.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    val page: Int,
    val results: List<Movie>
)

@Serializable
data class Movie(
    val original_title: String = "",
    val adult: Boolean = false,
    val poster_path: String? = null,
    val release_date: String? = null,
    val title: String? = null,
    val overview: String = "",
    val vote_average: Float = 0f
)
