package com.example.todolist.data.remote

import com.example.todolist.data.remote.dto.TodoDto
import retrofit2.http.GET

interface TodoApi {
    @GET("todos")
    suspend fun getTodos(): List<TodoDto>
}