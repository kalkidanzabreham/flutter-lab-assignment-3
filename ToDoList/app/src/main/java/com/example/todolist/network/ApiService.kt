package com.example.todolist.network

import retrofit2.http.GET
import retrofit2.Response

interface ApiService {
    @GET("todos")
    suspend fun getTodos(): Response<List<Todo>>
}