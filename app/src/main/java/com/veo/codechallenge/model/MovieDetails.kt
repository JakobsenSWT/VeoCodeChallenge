package com.veo.codechallenge.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieDetails(
    val adult: Boolean = false,
    val title: String? = null,
    val original_title: String = "",
    val overview: String? = null,
    val release_date: String? = null,
    val poster_path: String? = null,
    val vote_average: Float = 0f,
    val vote_count: Int = 0,
    val status: String? = null
)