package com.example.exampleapp.app

import ImageDatabase
import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.exampleapp.api.MyApi
import com.example.exampleapp.repos.ImageRepository
import com.example.exampleapp.ui.ImageViewModel
import com.example.exampleapp.utils.Constants
import com.example.exampleapp.utils.ImageDao
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


val apiModule = module {

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

}

val databaseModule = module {

    fun provideDatabase(application: Application): ImageDatabase {
        return Room.databaseBuilder(application, ImageDatabase::class.java, "countries")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideCountriesDao(database: ImageDatabase): ImageDao {
        return  database.imageDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideCountriesDao(get()) }
}

val repositoryModule = module {

    fun provideCountryRepository(api: MyApi, context: Context, dao : ImageDao): ImageRepository {
        return ImageRepository(api, context, dao)
    }
    single { provideCountryRepository(get(), androidContext(), get()) }

}

val viewModule = module {



    viewModel() { ImageViewModel(get()) }
}