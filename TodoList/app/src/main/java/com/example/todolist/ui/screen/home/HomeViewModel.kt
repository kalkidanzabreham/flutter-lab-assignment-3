package com.example.todolist.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.domain.model.Todo
import com.example.todolist.data.repository.TodoRepository
import com.example.todolist.domain.TodoRepositoryImpl
import com.example.todolist.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel(private val repository: TodoRepositoryImpl) : ViewModel() {
    private val _state = MutableStateFlow<Resource<List<Todo>>>(Resource.Loading())
    val state: StateFlow<Resource<List<Todo>>> = _state.asStateFlow()

    init {
        fetchTodos()
    }

    private fun fetchTodos() {
        viewModelScope.launch {
            try {
                repository.syncTodos()
                repository.getTodos().collect { todos ->
                    _state.value = Resource.Success(todos)
                }
            } catch (e: Exception) {
                repository.getTodos().collect {
                    _state.value = Resource.Error("Failed to fetch remote, showing cached data.", it)
                }
            }
        }
    }
}
