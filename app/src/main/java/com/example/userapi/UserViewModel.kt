package com.example.userapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<UserUiState>(UserUiState.Loading)

    val uiState: StateFlow<UserUiState> = _uiState.asStateFlow()

    init {
        getUsers()
    }

      fun getUsers() {
        viewModelScope.launch {
            _uiState.value = UserUiState.Loading
            try {
                val response = repository.getUsers()
                if (response.success) {
                    _uiState.value = UserUiState.Success(user = response.data.orEmpty())
                } else {
                    _uiState.value = UserUiState.Error(message = response.message)
                }
            } catch (e: Exception) {
                _uiState.value = UserUiState.Error(message = e.message ?: "Something went wrong")
            }
        }
    }

}
