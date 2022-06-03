package com.example.exampleapp.api

import com.example.exampleapp.models.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MyApi {
    @GET("/users/{id}")
    suspend fun getUser(@Path("id") userId: Int) :User
}