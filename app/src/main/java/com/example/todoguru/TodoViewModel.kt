package com.example.todoguru

import TodoDao
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.Date
import kotlin.random.Random

class TodoViewModel(private val todoDao: TodoDao) : ViewModel() {

    val todoList: LiveData<List<Todo>> = todoDao.getTodoItems()

    fun addTodoItem(title: String, description: String, color: Color) {
        viewModelScope.launch {
            todoDao.addTodoItem(
                Todo(
                    title = title,
                    description = description,
                    color = color.value.toInt(), // Convert Color to Int
                    createdAt = Date()
                )
            )
        }
    }

    fun deleteTodoItem(todo: Todo) {
        viewModelScope.launch {
            todoDao.deleteTodoItem(todo)
        }
    }

    fun updateTodoItem(todo: Todo) {
        viewModelScope.launch {
            todoDao.updateTodoItem(todo)
        }
    }

    fun pickRandomColor(colors: List<Color>): Color {
        if (colors.isEmpty()) {
            throw IllegalArgumentException("The color list cannot be empty")
        }
        val randomIndex = Random.nextInt(colors.size)
        return colors[randomIndex]
    }
}

class TodoViewModelFactory(private val todoDao: TodoDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TodoViewModel(todoDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
