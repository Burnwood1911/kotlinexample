package com.example.exampleapp.app

import com.example.exampleapp.api.MyApi
import com.example.exampleapp.utils.Constants
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val appModule = module {
    single {
        Retrofit.Builder().baseUrl(Constants.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create<MyApi>()
    }
}