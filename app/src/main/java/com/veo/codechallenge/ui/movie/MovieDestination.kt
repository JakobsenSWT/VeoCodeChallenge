package com.veo.codechallenge.ui.movie

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.veo.codechallenge.ui.Destination
import com.veo.codechallenge.ui.movie.details.composableMovieDetailsDestination

object MovieDestination: Destination {
    override val route: String = "Movies"
    override val arguments: List<NamedNavArgument> = emptyList()
}

fun NavGraphBuilder.navigationMovieDestination(
    onNavigateToDetails: (id: Int) -> Unit = { }
) =
    navigation(
        route = MovieDestination.route,
        startDestination = "${MovieDestination.route}/startDestination"
    ) {
        composableMovieDestination(
            onNavigateToDetails = onNavigateToDetails
        )

        composableMovieDetailsDestination()
    }

/** */
private fun NavGraphBuilder.composableMovieDestination(
    onNavigateToDetails: (id: Int) -> Unit = { }
) =
    composable(
        route = "${MovieDestination.route}/startDestination",
        arguments = MovieDestination.arguments
    ) {
        MovieScreen(
            viewModel = hiltViewModel(),
            onNavigateToDetails = onNavigateToDetails
        )
    }