package com.example.todolist// File: MainActivity.kt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.todolist.di.AppModule
import com.example.todolist.ui.screen.detail.DetailViewModel
import com.example.todolist.ui.screen.home.HomeViewModel
import com.example.todolist.ui.screen.navigation.NavGraph
import com.example.todolist.ui.theme.TodoListTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize dependency injection
        AppModule.provide(application)

        setContent {
            TodoListTheme {
                val navController = rememberNavController()

                val listViewModel = HomeViewModel(AppModule.repository)
                val detailViewModel = DetailViewModel(AppModule.repository)

                NavGraph(
                    navController = navController,
                    listVM = listViewModel,
                    detailVM = detailViewModel
                )
            }
        }
    }
}
