package com.example.todoguru

import TodoDatabase
import android.app.Application
import androidx.room.Room

class TodoApp : Application() {
    lateinit var database: TodoDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            TodoDatabase::class.java, "todo-database"
        ).build()
    }
}
