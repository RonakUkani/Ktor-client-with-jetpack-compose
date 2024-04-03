package com.sample.networking.repository

import com.sample.networking.api.ProductApiService
import com.sample.networking.data.response.BaseResponse
import com.sample.networking.data.response.Products

class ProductsRepositoryImpl(private val productApiService: ProductApiService) :
    ProductsRepository {
    override suspend fun getProductsList(): Result<Products> {
        return try {
            Result.success(productApiService.getProductList())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
