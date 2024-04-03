package com.sample.networking.repository

import com.sample.networking.data.response.BaseResponse
import com.sample.networking.data.response.Products

interface ProductsRepository {
    suspend fun getProductsList() : Result<Products>
}
