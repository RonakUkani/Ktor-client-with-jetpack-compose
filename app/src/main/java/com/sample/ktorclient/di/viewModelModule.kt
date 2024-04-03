package com.sample.ktorclient.di

import com.sample.ktorclient.viewmodel.ProductsViewmodel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ProductsViewmodel(get()) }
}