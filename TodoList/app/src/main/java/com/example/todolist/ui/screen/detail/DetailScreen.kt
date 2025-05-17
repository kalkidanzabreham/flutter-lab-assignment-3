package com.example.todolist.ui.screen.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState

@Composable
fun DetailScreen(id: Int, viewModel: DetailViewModel, navController: NavController) {
    LaunchedEffect(Unit) { viewModel.loadTodo(id) }
    val todo = viewModel.todo.collectAsState().value

    todo?.let {
        Text(text = "Title: ${it.title}\nCompleted: ${it.completed}")
    } ?: Text("Loading...")
}
