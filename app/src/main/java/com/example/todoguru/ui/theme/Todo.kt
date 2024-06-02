package com.example.todoguru.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant

import androidx.compose.ui.graphics.Color
import java.util.Date

data class Todo(
    val id: Long,
    val title: String,
    val description: String,
    val createdAt: Date,
    val color: Color
)

