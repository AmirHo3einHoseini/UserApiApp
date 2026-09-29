package com.example.userapi.remote

import com.example.userapi.model.ApiResponse
import com.example.userapi.model.CreateUserRequest
import com.example.userapi.model.UpdateUserRequest
import com.example.userapi.model.User
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserApi {


    @GET("users")
    suspend fun getUsers(): ApiResponse<List<User>>

    @POST("users")
    suspend fun createUser(
        @Body request: CreateUserRequest
    ): ApiResponse<User>

    @GET("users/{id}")
    suspend fun getUserById(
        @Path("id") id: Int
    ): ApiResponse<User>

    @PUT("users/{id}")
    suspend fun updateUSer(
        @Path("id") id: Int,
        @Body request: UpdateUserRequest
    ): ApiResponse<User>


    @DELETE("users/{id}")
    suspend fun deleteUser(
        @Path("id") id: Int
    ): ApiResponse<User>

}