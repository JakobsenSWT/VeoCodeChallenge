package com.veo.codechallenge.ui.movie.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
internal fun MovieDetailsScreen(
    viewModel: MovieDetailsViewModel
) {
    val viewData by remember(viewModel) { viewModel.viewData }

    MovieDetailsContent(
        viewData = viewData
    )
}