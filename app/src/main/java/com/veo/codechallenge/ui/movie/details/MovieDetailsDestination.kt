package com.veo.codechallenge.ui.movie.details

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.veo.codechallenge.ui.Destination

object MovieDetailsDestination: Destination {
    internal const val ID: String = "movie"

    override val route: String = "Details"
    override val arguments: List<NamedNavArgument> =
        listOf(
            navArgument(ID) { type = NavType.IntType }
        )
}

fun NavGraphBuilder.composableMovieDetailsDestination() =
    composable(
        route = "${MovieDetailsDestination.route}/{${MovieDetailsDestination.ID}}",
        arguments = MovieDetailsDestination.arguments
    ) {
        MovieDetailsScreen(
            viewModel = hiltViewModel()
        )
    }