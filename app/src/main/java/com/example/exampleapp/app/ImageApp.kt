package com.example.exampleapp.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class ImageApp: Application() {


    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@ImageApp)
            modules(apiModule,
                databaseModule,
                repositoryModule,
                viewModule)
        }
    }
}