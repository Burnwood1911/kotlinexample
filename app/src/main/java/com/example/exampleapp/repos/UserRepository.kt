package com.example.exampleapp.repos

import com.example.exampleapp.api.MyApi
import com.example.exampleapp.models.User

class UserRepository(private val api:MyApi) {

    suspend fun getUser(id: Int): User {
        return api.getUser(id)
    }
}