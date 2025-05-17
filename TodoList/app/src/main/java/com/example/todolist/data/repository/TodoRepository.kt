package com.example.todolist.data.repository

import com.example.todolist.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getTodos(): Flow<List<Todo>>
    suspend fun getTodoById(id: Int): Todo?
}