package com.example.omikuji.data

import androidx.room.TypeConverter
import java.time.ZonedDateTime

class Converters {
    @TypeConverter
    fun fromZonedDateTime(zonedDateTime: ZonedDateTime): String = zonedDateTime.toString()

    @TypeConverter
    fun toZonedDateTime(string: String): ZonedDateTime = ZonedDateTime.parse(string)
}