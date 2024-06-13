package com.example.todoguru



import java.util.Date

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
@Entity(tableName = "todos_table")
data class Todo(
    @PrimaryKey(autoGenerate = false)
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val color: Int,
    val createdAt: Date
)