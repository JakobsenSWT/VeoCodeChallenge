package com.veo.codechallenge.repository

import androidx.annotation.AnyThread
import com.veo.codechallenge.model.Movie
import com.veo.codechallenge.model.MovieDetails
import com.veo.codechallenge.request.Result.Failure
import com.veo.codechallenge.request.Result.Success
import com.veo.codechallenge.request.service.VeoService
import com.veo.codechallenge.request.utils.doRequest
import com.veo.codechallenge.request.utils.then
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val veoService: VeoService
) {

    @AnyThread
    suspend fun getMovies(): List<Movie> =
        doRequest { veoService.movies() }
            .then { result ->
                when (result) {
                    is Success -> { result.data.results }
                    is Failure -> { emptyList() }
                }
            }

    @AnyThread
    suspend fun getMovieDetails(movie: Int): MovieDetails =
        doRequest { veoService.details(movie) }
            .then { result ->
                when (result) {
                    is Success -> { result.data }
                    is Failure -> { MovieDetails() }
                }
            }
}

@Module
@InstallIn(ActivityRetainedComponent::class)
object MovieRepositoryModule {

    @Provides
    fun provideMovieRepository(service: VeoService) =
        MovieRepository(veoService = service)
}