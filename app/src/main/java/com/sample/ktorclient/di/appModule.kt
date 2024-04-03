package com.sample.ktorclient.di

import com.sample.networking.di.networkModule
import com.sample.networking.di.repositoryModule
import org.koin.dsl.module

val appModule = module {
    includes(viewModelModule, networkModule, repositoryModule)
}