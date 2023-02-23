package com.veo.codechallenge.ui.utils

import androidx.compose.runtime.MutableState

suspend inline fun <reified T> MutableState<T>.update(crossinline function: suspend T.() -> T) {
    value = value.function()
}