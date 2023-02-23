package com.veo.codechallenge.ui.movie

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.veo.codechallenge.request.Result.Failure
import com.veo.codechallenge.request.Result.Success
import com.veo.codechallenge.request.service.VeoService
import com.veo.codechallenge.request.utils.doRequest
import com.veo.codechallenge.request.utils.then
import com.veo.codechallenge.ui.utils.update
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MovieViewModel @Inject constructor(
    private val veoService: VeoService
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
            doRequest { veoService.movies() }
                .then { result ->
                    when (result) {
                        is Success -> { mutableViewData.update { copy(movies = result.data, isLoading = false) } }
                        is Failure -> { mutableViewData.update { copy(isLoading = false) } }
                    }
                }
        }
    }
}