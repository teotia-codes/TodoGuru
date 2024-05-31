package com.example.todoguru.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoListPage() {
    var todoList = getFakeTodo()
    Column {
        LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
            itemsIndexed(todoList){index, item->
                Card(onClick = { /*TODO*/ }) {
                    Column {
                        Text(text =item.title, fontWeight = FontWeight.ExtraBold,
                            fontSize = 24.sp, color = Color.White)
                        Text(text = item.description, color = Color.White)
                        Text(text =SimpleDateFormat("HH:mm:aa,dd/mm", Locale.ENGLISH).format(item.createdAt.toString()) )

                    }

                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        })
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun Per() {
    TodoListPage()
}