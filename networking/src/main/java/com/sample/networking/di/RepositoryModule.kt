package com.sample.networking.di

import com.sample.networking.repository.ProductsRepository
import com.sample.networking.repository.ProductsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<ProductsRepository> { ProductsRepositoryImpl(get()) }
}
