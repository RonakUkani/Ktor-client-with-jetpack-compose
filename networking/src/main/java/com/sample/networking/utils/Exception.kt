package com.sample.networking.utils

import com.sample.networking.data.response.BaseResponse
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException


fun Exception.toCustomExceptions() = when (this) {
    is ServerResponseException -> httpErrorInternalServerError(this)
    is ClientRequestException ->
        when (this.response.status.value) {
            400 -> httpErrorBadRequest(this)
            401 -> httpErrorUnauthorized(this)
            403 -> httpErrorForbidden(this)
            404 -> httpErrorNotFound(this)
            else -> httpError(this)
        }

    is RedirectResponseException -> httpError(this)
    else -> genericError(this)
}

private fun genericError(exception: Exception) {

}

private fun httpError(redirectResponseException: RedirectResponseException) {

}

private fun httpError(clientRequestException: ClientRequestException) {

}

private fun httpErrorNotFound(clientRequestException: ClientRequestException) {

}

private fun httpErrorForbidden(clientRequestException: ClientRequestException) {

}

private fun httpErrorUnauthorized(clientRequestException: ClientRequestException) {

}

private fun httpErrorBadRequest(clientRequestException: ClientRequestException) {

}

private fun httpErrorInternalServerError(serverResponseException: ServerResponseException) {

}
