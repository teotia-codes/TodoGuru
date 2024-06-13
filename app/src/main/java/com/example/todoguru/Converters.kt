package com.example.todoguru

import androidx.compose.ui.graphics.Color
import androidx.room.TypeConverter
import java.util.Date
import java.util.UUID

class Converters {

    @TypeConverter
    fun fromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun toDate(time: Long): Date {
        return Date(time)
    }

    @TypeConverter
    fun fromStringToUUID(value: String?): UUID {
        return value.let { UUID.fromString(it) }
    }

    @TypeConverter
    fun uuidToString(uuid: UUID): String {
        return uuid.toString()
    }

    @TypeConverter
    fun fromColorInt(color: Int): Color {
        return Color(color)
    }

    @TypeConverter
    fun colorToInt(color: Color): Int {
        return color.value.toInt()
    }
}
