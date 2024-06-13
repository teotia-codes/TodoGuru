/*
class TodoRepository(private val todoDao: TodoDao) {

    suspend fun getTodoItems(): List<Todo> {
        return withContext(Dispatchers.IO) {
            todoDao.getTodoItems()
        }
    }

    suspend fun addTodoItem(title: String, description: String, color: Color) {
        val newTodo = Todo(
            title = title,
            description = description,
            color = color,
            createdAt = Date()
        )
        withContext(Dispatchers.IO) {
            todoDao.addTodoItem(newTodo)
        }
    }

    suspend fun deleteTodoItem(todoItem: Todo) {
        withContext(Dispatchers.IO) {
            todoDao.deleteTodoItem(todoItem)
        }
    }

    suspend fun updateTodoItem(updatedTodo: Todo) {
        withContext(Dispatchers.IO) {
            todoDao.updateTodoItem(updatedTodo)
        }
    }
}
*/