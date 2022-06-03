package com.example.exampleapp.api

import com.example.exampleapp.models.Image
import retrofit2.http.GET

interface MyApi {
    @GET("/list")
    suspend fun getImages() : List<Image>
}