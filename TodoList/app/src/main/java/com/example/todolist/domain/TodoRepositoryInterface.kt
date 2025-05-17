package com.example.todolist.domain

import com.example.todolist.data.local.TodoDao
import com.example.todolist.data.local.entities.TodoEntity
import com.example.todolist.data.remote.TodoApi
import com.example.todolist.data.remote.dto.TodoDto
import com.example.todolist.data.repository.TodoRepository
import com.example.todolist.domain.model.Todo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TodoRepositoryImpl(
    private val api: TodoApi,
    private val dao: TodoDao
) : TodoRepository {

    override fun getTodos(): Flow<List<Todo>> {
        return dao.getTodos().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun getTodoById(id: Int): Todo? {
        return dao.getTodoById(id)?.toDomain()
    }

    suspend fun syncTodos() {
        val remoteTodos = api.getTodos()
        dao.insertTodos(remoteTodos.map { it.toEntity() })
    }
}

fun TodoEntity.toDomain() = Todo(id, userId, title, completed)
fun TodoDto.toEntity() = TodoEntity(id, userId, title, completed)
