package com.veo.codechallenge.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    val results: List<Movie>
)

@Serializable
data class Movie(
    val id: Int,
    val title: String? = null,
    val original_title: String = "",
    val release_date: String? = null,
    val backdrop_path: String? = null,
    val vote_average: Float = 0f
)
