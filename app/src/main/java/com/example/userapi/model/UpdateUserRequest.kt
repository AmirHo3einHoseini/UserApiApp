package com.example.userapi.model

import kotlinx.serialization.Serializable

@Serializable
data class UpdateUserRequest(
    val name: String,
    val age: Int
)