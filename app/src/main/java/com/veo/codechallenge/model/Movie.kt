package com.veo.codechallenge.model

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val posterPath: String? = null,
    val releaseData: String,
    val title: String,
    val overview: String
)
