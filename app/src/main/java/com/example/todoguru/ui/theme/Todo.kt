package com.example.todoguru.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import java.time.Instant
import java.util.Date

data class Todo(
    var id: Int,
    var title: String,
    var description: String,
    var createdAt: Date,
    var color: Color
)

@RequiresApi(Build.VERSION_CODES.O)
fun getFakeTodo(): List<Todo> {
    return listOf<Todo>(
        Todo(
            0,
            title = "Morning Routine",
            description = "Start your day by waking up on time, followed by a morning exercise routine such as yoga or running to boost your energy levels. Have a healthy breakfast to kickstart your metabolism and then take a shower to refresh and get ready for the day ahead.",
            createdAt = Date.from(Instant.now()),
            color =  Color.Red.copy(alpha = 0.85f)
        ),
        Todo(
            1,
            title = "Work Tasks",
            description = "Begin your workday by checking and responding to important emails, then participate in the daily team meeting to sync with your colleagues. Focus on completing the project report and ensure it is thoroughly reviewed before submission. Lastly, record and submit your timesheet to keep track of your hours worked",
            createdAt = Date.from((Instant.now())),
            color = Color.Green.copy(alpha = 0.85f)

        ),
        Todo(
            2,
            title = "Household Chores",
            description = "Keep your home tidy by cleaning the kitchen and washing the dishes. Do the laundry by washing, drying, and folding your clothes. Go grocery shopping to stock up on essentials for the week and water all your indoor and outdoor plants to keep them healthy.",
            createdAt = Date.from(Instant.now()),
            color = Color.Yellow.copy(alpha = 0.85f)

        ),
        Todo(
            3,
            title = "Self-Care",
            description = "Take some time for yourself by reading a book for pleasure or learning, and practice mindfulness meditation to relax and center yourself. Enjoy a leisurely walk outside to clear your mind and make sure to schedule a doctor's appointment for a regular health check-up.",
            createdAt = Date.from(Instant.now()),
            color = Color.Blue.copy(alpha = 0.85f)
        ),

        Todo(
                4,
                title = "Social Tasks",
                description = "Check in with your family by giving them a call and organize a get-together with friends. Attend a professional networking event and express gratitude by sending thank-you notes.",
                createdAt = Date.from(Instant.now()),
            color = Color.Magenta.copy(alpha = 0.85f)

        )



    )
}