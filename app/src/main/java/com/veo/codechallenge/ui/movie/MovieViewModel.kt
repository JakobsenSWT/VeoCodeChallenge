package com.veo.codechallenge.ui.movie

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MovieViewModel @Inject constructor() : ViewModel() {

    private val mutableViewData = mutableStateOf(MovieViewData())
    val viewData: State<MovieViewData> = mutableViewData

    init {
        viewModelScope.launch {

        }
    }

    fun refresh() {
        viewModelScope.launch {

        }
    }
}