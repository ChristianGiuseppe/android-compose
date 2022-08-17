package com.example.noteapp.util

import androidx.room.TypeConverter
import java.util.*

class DataConverter {

    @TypeConverter
    fun timeStampConverter(date: Date) : Long {
        return date.time
    }

    @TypeConverter
    fun  dateFromTimeStamp(timeStamp: Long): Date{
        return Date(timeStamp)
    }

}