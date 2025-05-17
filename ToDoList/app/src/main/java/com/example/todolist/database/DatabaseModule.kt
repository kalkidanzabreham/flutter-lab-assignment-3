package com.example.todolist.database

import android.app.Application
import androidx.room.Room

object DatabaseModule {
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    fun provideTodoDao(database: AppDatabase): TodoDao {
        return database.todoDao()
    }
}