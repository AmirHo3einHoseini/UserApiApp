package com.example.userapi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen(
    viewmodel: UserViewModel = viewModel()
) {
    val state by viewmodel.uiState.collectAsState()

    when (val state = state) {
        UserUiState.Loading -> {
            CircularProgressIndicator()
        }


        is UserUiState.Success -> {
            LazyColumn(
                modifier = Modifier
                    .padding(48.dp)
            ) {
                items(state.user) { user ->
                    UserItem(user = user)
                }
            }
        }

        is UserUiState.Error -> {
            Column {
                Text(text = state.message)
                Button(
                    onClick = {
                        viewmodel.getUsers()
                    }
                ) {
                    Text("Retry")
                }
            }
        }
    }

}