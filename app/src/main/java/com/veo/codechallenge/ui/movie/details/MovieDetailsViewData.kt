package com.veo.codechallenge.ui.movie.details

import com.veo.codechallenge.model.MovieDetails

internal data class MovieDetailsViewData(
    val movie: MovieDetails = MovieDetails(),
    val isLoading: Boolean = true
)