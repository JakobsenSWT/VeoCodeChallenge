package com.veo.codechallenge.ui.movie

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
internal fun MovieScreen(
    viewModel: MovieViewModel,
    onNavigateToDetails: () -> Unit
) {
    val viewData by remember(viewModel) { viewModel.viewData }

    MovieContent(
        viewData = viewData,
        onRefresh = viewModel::refresh,
        onDetailsClick = onNavigateToDetails
    )
}