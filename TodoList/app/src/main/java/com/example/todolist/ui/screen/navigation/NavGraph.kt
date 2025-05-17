package com.example.todolist.ui.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todolist.ui.screen.detail.DetailScreen
import com.example.todolist.ui.screen.detail.DetailViewModel
import com.example.todolist.ui.screen.home.HomeScreen
import com.example.todolist.ui.screen.home.HomeViewModel


@Composable
fun NavGraph(navController: NavHostController, listVM: HomeViewModel, detailVM: DetailViewModel) {
    NavHost(navController = navController, startDestination = "list") {
        composable("list") { HomeScreen(listVM, navController) }
        composable("detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toInt() ?: 0
            DetailScreen(id, detailVM, navController)
        }
    }
}