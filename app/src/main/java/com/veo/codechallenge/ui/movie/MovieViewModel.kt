package com.veo.codechallenge.ui.movie

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.veo.codechallenge.repository.MovieRepository
import com.veo.codechallenge.ui.utils.update
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val mutableViewData = mutableStateOf(MovieViewData())
    val viewData: State<MovieViewData> = mutableViewData

    init {
        viewModelScope.launch {
            refresh()
        }
    }

    fun refresh() {
        viewModelScope.launch {
            mutableViewData.update { copy(isLoading = true) }
            mutableViewData.update { copy(movies = movieRepository.getMovies(), isLoading = false) }
        }
    }
}