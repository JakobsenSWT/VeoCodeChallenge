package com.veo.codechallenge.ui.movie.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.veo.codechallenge.request.Result
import com.veo.codechallenge.request.service.VeoService
import com.veo.codechallenge.request.utils.doRequest
import com.veo.codechallenge.request.utils.then
import com.veo.codechallenge.ui.utils.update
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MovieDetailsViewModel @Inject constructor(
    private val veoService: VeoService,
    private val savedState: SavedStateHandle
) : ViewModel() {

    private val mutableViewData = mutableStateOf(MovieDetailsViewData())
    val viewData: State<MovieDetailsViewData> = mutableViewData

    init {
        viewModelScope.launch {
            checkNotNull(savedState.get<Int>(MovieDetailsDestination.ID)).let { id ->
                doRequest { veoService.details(id) }
                    .then { result ->
                        when (result) {
                            is Result.Success -> { mutableViewData.update { copy(movie = result.data, isLoading = false) } }
                            is Result.Failure -> { mutableViewData.update { copy(isLoading = false) } }
                        }
                    }
            }
        }
    }
}