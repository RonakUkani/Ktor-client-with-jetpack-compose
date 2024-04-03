package com.sample.ktorclient.util

import com.sample.networking.result.NetworkError
import java.lang.RuntimeException

fun Throwable.toNetworkError(): NetworkError {
    return when(this) {
        is NetworkError -> this
        is Exception -> NetworkError.create(this)
        else -> NetworkError.create(RuntimeException(this))
    }
}
