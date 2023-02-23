package com.veo.codechallenge.ui.movie

import com.veo.codechallenge.model.Movie

internal data class MovieViewData(
    val movies: List<Movie> = emptyList(),
    val isLoading: Boolean = false
)