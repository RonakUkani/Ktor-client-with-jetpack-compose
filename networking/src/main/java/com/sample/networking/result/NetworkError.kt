package com.sample.networking.result

import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import java.net.UnknownHostException

class NetworkError(var errorType: NetworkErrorType) : Throwable() {

    companion object {
        fun create(e: Exception): NetworkError {
            return when (e) {
                is UnknownHostException -> NetworkError(NetworkErrorType.LocalNetworkError)
                is ServerResponseException -> NetworkError(NetworkErrorType.HttpErrorInternalServerError)
                is ClientRequestException ->
                    when (e.response.status.value) {
                        400 -> NetworkError(NetworkErrorType.HttpErrorBadRequest)
                        401 -> NetworkError(NetworkErrorType.HttpErrorUnauthorized)
                        403 -> NetworkError(NetworkErrorType.HttpErrorForbidden)
                        404 -> NetworkError(NetworkErrorType.HttpErrorNotFound)
                        else -> NetworkError(NetworkErrorType.HttpError)
                    }

                is RedirectResponseException -> NetworkError(NetworkErrorType.RedirectResponseError)
                else -> NetworkError(NetworkErrorType.OtherError)
            }
        }
    }

    sealed class NetworkErrorType {
        data object LocalNetworkError : NetworkErrorType()
        data object HttpErrorInternalServerError : NetworkErrorType()
        data object HttpErrorBadRequest : NetworkErrorType()
        data object HttpErrorUnauthorized : NetworkErrorType()
        data object HttpErrorForbidden : NetworkErrorType()
        data object HttpErrorNotFound : NetworkErrorType()
        data object HttpError : NetworkErrorType()
        data object RedirectResponseError : NetworkErrorType()
        data object OtherError : NetworkErrorType()
    }

}