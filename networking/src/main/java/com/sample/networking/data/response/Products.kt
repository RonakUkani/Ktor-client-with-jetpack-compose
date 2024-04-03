package com.sample.networking.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Products(
    @SerialName("products")
    val products: List<Product?>? = listOf(),
    @SerialName("total")
    val total: Int? = 0,
    @SerialName("skip")
    val skip: Int? = 0,
    @SerialName("limit")
    val limit: Int? = 0
) {
    @Serializable
    data class Product(
        @SerialName("id")
        val id: Int? = 0,
        @SerialName("title")
        val title: String? = "",
        @SerialName("description")
        val description: String? = "",
        @SerialName("price")
        val price: Int? = 0,
        @SerialName("discountPercentage")
        val discountPercentage: Double? = 0.0,
        @SerialName("rating")
        val rating: Double? = 0.0,
        @SerialName("stock")
        val stock: Int? = 0,
        @SerialName("brand")
        val brand: String? = "",
        @SerialName("category")
        val category: String? = "",
        @SerialName("thumbnail")
        val thumbnail: String? = "",
        @SerialName("images")
        val images: List<String?>? = listOf()
    )
}