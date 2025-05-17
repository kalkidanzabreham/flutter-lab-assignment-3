package com.example.todolist.di

import android.app.Application
import androidx.room.Room
import com.example.todolist.data.local.TodoDatabase
import com.example.todolist.data.remote.TodoApi
import com.example.todolist.domain.TodoRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {
    lateinit var repository: TodoRepositoryImpl

    fun provide(app: Application) {
        val db = Room.databaseBuilder(app, TodoDatabase::class.java, "todos.db").build()
        val api = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodoApi::class.java)

        repository = TodoRepositoryImpl(api, db.dao)
    }
}