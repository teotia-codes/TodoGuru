import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todoguru.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM todos_table")
     fun getTodoItems(): LiveData<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend  fun addTodoItem(todo: Todo)

    @Delete
   suspend  fun deleteTodoItem(todo: Todo)

    @Update
    suspend fun updateTodoItem(todo: Todo)
}
