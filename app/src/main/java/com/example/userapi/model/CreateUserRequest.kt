package com.example.userapi.model

import kotlinx.serialization.Serializable

@Serializable
data class CreateUserRequest(
    val name: String,
    val age: Int
)
