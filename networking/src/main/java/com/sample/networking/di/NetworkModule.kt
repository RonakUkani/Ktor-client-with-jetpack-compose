package com.sample.networking.di

import com.sample.networking.api.ProductApiService
import com.sample.networking.client.ktorHttpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

val networkModule = module {
    single { productApiService(get()) }
    single { provideKtorHttpClient() }
}

fun productApiService(httpClient: HttpClient) : ProductApiService{
    return ProductApiService(httpClient)
}

private fun provideKtorHttpClient() : HttpClient {
    return ktorHttpClient
}
