package com.sample.networking.data.response

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val data: T? = null,
    val message: String = ""
)
