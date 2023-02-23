package com.veo.codechallenge.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.veo.codechallenge.ui.movie.MovieDestination
import com.veo.codechallenge.ui.movie.composableMovieDestination

@Composable
fun MyAppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = MovieDestination.route
    ) {

        composableMovieDestination(
            // onNavigateToDetails = { navController.navigate("") }
        )
    }
}