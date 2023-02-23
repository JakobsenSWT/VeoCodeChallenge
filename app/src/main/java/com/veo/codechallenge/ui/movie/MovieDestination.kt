package com.veo.codechallenge.ui.movie

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.veo.codechallenge.ui.Destination

object MovieDestination: Destination {
    override val route: String = "Movies"
    override val arguments: List<NamedNavArgument> = emptyList()
}

/** */
fun NavGraphBuilder.composableMovieDestination(
    onNavigateToDetails: () -> Unit = { }
) =
    composable(
        route = MovieDestination.route,
        arguments = MovieDestination.arguments
    ) {
        MovieScreen(
            viewModel = hiltViewModel(),
            onNavigateToDetails = onNavigateToDetails
        )
    }