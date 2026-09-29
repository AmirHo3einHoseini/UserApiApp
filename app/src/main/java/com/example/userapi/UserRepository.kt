package com.example.userapi

import com.example.userapi.model.ApiResponse
import com.example.userapi.model.CreateUserRequest
import com.example.userapi.model.UpdateUserRequest
import com.example.userapi.model.User
import com.example.userapi.remote.RetrofitInstance
import com.example.userapi.remote.UserApi

class UserRepository(
    private val api: UserApi
) {


    suspend fun getUsers(): ApiResponse<List<User>> {

        return api.getUsers()
    }

    suspend fun createUser(
        request: CreateUserRequest
    ): ApiResponse<User> {
        return api.createUser(request)
    }

    suspend fun getUserById(id: Int): ApiResponse<User> {
        return api.getUserById(id)
    }

    suspend fun updateUser(
        id: Int,
        request: UpdateUserRequest
    ): ApiResponse<User> {
        return api.updateUSer(id, request)
    }

    suspend fun deleteUser(
        id: Int
    ): ApiResponse<User> {
        return api.deleteUser(id)
    }


}