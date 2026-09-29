package com.example.userapi

import com.example.userapi.model.User

sealed interface UserUiState {

    data object Loading : UserUiState
    data class Success(
        val user: List<User>
    ): UserUiState

    data class Error(
        val message: String
    ) : UserUiState
}