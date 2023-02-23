package com.veo.codechallenge.request.utils

import com.veo.codechallenge.request.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend inline fun <T> doRequest(crossinline service: suspend () -> T): Result<T> = Result {
    withContext(Dispatchers.IO) {
        service()
    }
}

suspend fun <T,R> Result<T>.then(process: suspend (Result<T>) -> R) =
    process(this)