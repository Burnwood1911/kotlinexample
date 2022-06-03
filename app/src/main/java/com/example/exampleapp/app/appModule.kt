package com.example.exampleapp.app

import com.example.exampleapp.api.MyApi
import com.example.exampleapp.repos.UserRepository
import com.example.exampleapp.ui.UserViewModel
import com.example.exampleapp.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


val appModule = module {
    single {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        Retrofit.Builder().baseUrl(Constants.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create<MyApi>()
    }

    single { UserRepository(get()) }

    viewModel { UserViewModel(get()) }
}