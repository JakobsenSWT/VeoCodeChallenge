package com.veo.codechallenge.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.veo.codechallenge.ui.movie.MovieDestination
import com.veo.codechallenge.ui.movie.details.MovieDetailsDestination
import com.veo.codechallenge.ui.movie.navigationMovieDestination

@Composable
fun MyAppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = MovieDestination.route
    ) {

        navigationMovieDestination(
            onNavigateToDetails = { navController.navigate("${MovieDetailsDestination.route}/$it") }
        )
    }
}