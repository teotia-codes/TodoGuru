import androidx.compose.ui.graphics.Color
import com.example.todoguru.ui.theme.Todo
import java.util.*

object TodoRepository {
    private val todoItems = mutableListOf<Todo>()

    fun getTodoItems(): List<Todo> {
        return todoItems
    }

    fun addTodoItem(title: String, description: String, color: Color) {
        val newTodo = Todo(
            title = title,
            description = description,
            color = color,
            createdAt = Date()
        )
        todoItems.add(newTodo)
    }

    fun deleteTodoItem(todoItem: Todo) {
        todoItems.remove(todoItem)
    }

    fun updateTodoItem(updatedTodo: Todo) {
        val index = todoItems.indexOfFirst { it.id == updatedTodo.id }
        if (index != -1) {
            todoItems[index] = updatedTodo
        }
    }
}