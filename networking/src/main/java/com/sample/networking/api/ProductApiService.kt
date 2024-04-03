package com.sample.networking.api

import com.sample.networking.data.response.BaseResponse
import com.sample.networking.data.response.Products
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ProductApiService(private val client: HttpClient) {

    private val BASE_URL = "https://dummyjson.com/"
    private val PRODUCT_LIST = "products"

    suspend fun getProductList(): Products =
        client.get("$BASE_URL$PRODUCT_LIST")
}
