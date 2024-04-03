package com.sample.ktorclient

import android.app.Application
import com.sample.ktorclient.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplicationClass : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplicationClass)
            modules(appModule)
        }
    }
}
