package com.veo.codechallenge.ui.movie.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
internal fun MovieDetailsContent(
    viewData: MovieDetailsViewData
) {
    Text(text = viewData.movie.toString())
}