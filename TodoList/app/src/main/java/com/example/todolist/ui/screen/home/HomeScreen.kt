package com.example.todolist.ui.screen.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import com.example.todolist.util.Resource

@Composable
fun HomeScreen(viewModel: HomeViewModel, navController: NavController) {
    val state = viewModel.state.collectAsState().value

    when (state) {
        is Resource.Loading -> CircularProgressIndicator()
        is Resource.Success -> LazyColumn {
            items(state.data ?: emptyList()) { todo ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        navController.navigate("detail/${todo.id}")
                    }) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(todo.title)
                        Text(if (todo.completed) "Completed" else "Incomplete")
                    }
                }
            }
        }
        is Resource.Error -> Text("Error: ${state.message}")
    }
}


