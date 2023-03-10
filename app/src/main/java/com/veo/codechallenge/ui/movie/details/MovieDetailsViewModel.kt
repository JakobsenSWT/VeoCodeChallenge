package com.veo.codechallenge.ui.movie.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.veo.codechallenge.repository.MovieRepository
import com.veo.codechallenge.ui.utils.update
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MovieDetailsViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val savedState: SavedStateHandle
) : ViewModel() {

    private val mutableViewData = mutableStateOf(MovieDetailsViewData())
    val viewData: State<MovieDetailsViewData> = mutableViewData

    init {
        viewModelScope.launch {
            checkNotNull(savedState.get<Int>(MovieDetailsDestination.ID)).let { id ->
                mutableViewData.update { copy(movie = movieRepository.getMovieDetails(id), isLoading = false) }
            }
        }
    }
}