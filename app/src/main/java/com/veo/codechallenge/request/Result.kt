package com.veo.codechallenge.request

import retrofit2.HttpException

sealed class Result<T> {
    class Success<T>(val data: T): Result<T>()

    // Data is always null
    class Failure<T>(val data: T?, val cause: HttpException): Result<T>()

    companion object {
        suspend operator fun <T> invoke(func: suspend () -> T): Result<T> =
            try {
                Success(func())
            } catch (error: HttpException) {
                Failure(null, error)
            }
    }
}