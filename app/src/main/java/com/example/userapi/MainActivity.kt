package com.example.userapi


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.userapi.remote.RetrofitInstance


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = UserRepository(RetrofitInstance.api)
        val factory = UsersViewModelFactory(repository)

        setContent {
            val viewModel: UserViewModel = viewModel(factory = factory)
            UserListScreen(viewModel)

        }
    }


}