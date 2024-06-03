package com.example.todoguru.ui.theme



import java.util.Date

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val color: Color,
    val createdAt: Date
)
