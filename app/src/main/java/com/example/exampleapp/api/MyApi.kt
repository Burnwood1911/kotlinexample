package com.example.exampleapp.api

import com.example.exampleapp.models.User
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {
    @GET("/users/1")
    suspend fun getUser() : Response<User>
}