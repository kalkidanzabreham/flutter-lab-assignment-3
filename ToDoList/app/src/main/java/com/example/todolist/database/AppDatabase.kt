package com.example.todolist.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.model.Todo

@Database(
    entities = [Todo::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        const val DATABASE_NAME = "todo_db"
    }
}