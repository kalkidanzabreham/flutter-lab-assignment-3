package com.example.todolist.domain.model

data class Todo(
    val id: Int,
    val userId: Int,
    val title: String,
    val completed: Boolean
)