package com.example.noteapp.util

import androidx.room.TypeConverter
import java.util.*

class UUIDConverter {

    @TypeConverter
    fun fromUUIDToString(uuid: UUID): String? {
        return uuid.toString()
    }

    fun uuidFromString(uuidString:String?): UUID?{
        return UUID.fromString(uuidString)
    }
}