package com.example.todoguru


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoListPage(viewModel: TodoViewModel) {
    val todoList by viewModel.todoList.observeAsState(emptyList())
    var showDialog by remember { mutableStateOf(false) }
    var inputTitle by remember { mutableStateOf("") }
    var inputDescription by remember { mutableStateOf("") }
    var inputColor by remember { mutableStateOf(Color.Gray) } // Default color
    var editingTodo by remember { mutableStateOf<Todo?>(null) }
    val colors = listOf(
        Color.Red.copy(alpha = 0.75f),
        Color.Blue.copy(alpha = 0.75f),
        Color.Green.copy(alpha = 0.75f),
        Color.Yellow.copy(alpha = 0.75f),
        Color.Magenta.copy(alpha = 0.75f)
    )

    Scaffold(
        contentColor = Color.Black,
        containerColor = Color.Black,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "TodoGuru",
                        color = Color.White,
                        fontSize = 44.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.Black)
            )
        },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                    itemsIndexed(todoList) { index, item ->
                        Card(
                            onClick = {
                                editingTodo = item
                                inputTitle = item.title
                                inputDescription = item.description
                                inputColor = viewModel.pickRandomColor(colors)
                                showDialog = true
                            },
                            modifier = Modifier.padding(8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(item.color)) // Convert Int to Color
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = item.title,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 24.sp,
                                    color = Color.White
                                )

                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = item.description,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Row {
                                    Text(
                                        text = "CreatedAt      ",
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = SimpleDateFormat("HH:mm aa, dd/MM", Locale.ENGLISH)
                                            .format(item.createdAt),
                                        color = Color.White,
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                }
                            }

                            IconButton(onClick = {
                                viewModel.deleteTodoItem(todo = item)
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete Todo",
                                    tint = Color.DarkGray
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                })
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                editingTodo = null
                inputTitle = ""
                inputDescription = ""
                inputColor = Color.Gray
                showDialog = true
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.edit_note),
                    contentDescription = "Edit Todo",
                    modifier = Modifier
                        .height(48.dp)
                        .width(38.dp)
                )
            }
        }
    )

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = if (editingTodo == null) "Add New Todo" else "Edit Todo") },
            text = {
                Column {
                    OutlinedTextField(
                        value = inputTitle,
                        onValueChange = { inputTitle = it },
                        label = { Text("Todo Title") }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = inputDescription,
                        onValueChange = { inputDescription = it },
                        label = { Text("Todo Description") }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Select Color")
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        listOf(
                            Color.Gray, Color.Red, Color.Green, Color.Blue,
                            Color.Yellow, Color.Cyan, Color.Magenta
                        ).forEach { color ->
                            Spacer(modifier = Modifier.width(4.dp))
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(color, CircleShape)
                                    .clickable {
                                        inputColor = color
                                    }
                            )
                        }
                    }
                }
            },
            confirmButton = {
                Button(onClick = {
                    if (inputTitle.isNotEmpty() && inputDescription.isNotEmpty()) {
                        if (editingTodo == null) {
                            viewModel.addTodoItem(
                                title = inputTitle,
                                description = inputDescription,
                                color = inputColor,
                            )
                        } else {
                            viewModel.updateTodoItem(editingTodo!!.copy(
                                title = inputTitle,
                                description = inputDescription,
                                color = inputColor.value.toInt() // Convert Color to Int
                            ))
                        }

                        inputTitle = ""
                        inputDescription = ""
                        showDialog = false

                    }
                }) {
                    Text(if (editingTodo == null) "Add" else "Save")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}
