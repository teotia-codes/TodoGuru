package com.example.todoguru.ui.theme

import androidx.compose.ui.graphics.Color
import java.util.Date

object TodoRepository {
    private val todoList = mutableListOf<Todo>(
        Todo(
            id = 0,
            title = "Buy Groceries",
            description = "Milk, Bread, Eggs, Butter",
            createdAt = Date(),
            color = Color(0xFFFFA726) // Orange
        ),
        Todo(
            id = 1,
            title = "Workout",
            description = "Morning run and yoga",
            createdAt = Date(),
            color = Color(0xFF66BB6A) // Green
        ),
        Todo(
            id = 2,
            title = "Read Book",
            description = "Read 'Atomic Habits'",
            createdAt = Date(),
            color = Color(0xFF42A5F5) // Blue
        )
    )
    private var nextId: Long = todoList.size.toLong()

    fun addTodoItem(title: String, description: String, color: Color) {
        val newTodo = Todo(title = title, description = description, color = color, createdAt = Date(), id = 1)
        todoList.add(newTodo)
    }

    fun getTodoItems(): List<Todo> {
        return todoList
    }

    fun updateTodoItem(item: Todo) {
        val index = todoList.indexOfFirst { it.id == item.id }
        if (index != -1) {
            todoList[index] = item
        }
    }

    fun deleteTodoItem(id: Todo) {
        todoList.remove(id)
    }
}
