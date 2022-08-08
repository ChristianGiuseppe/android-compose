package com.example.noteapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteapp.model.Note

@RequiresApi(Build.VERSION_CODES.O)
@Database(entities = [Note::class], version = 1, exportSchema = false )
abstract class  NoteDatabase: RoomDatabase() {
    abstract  fun noteDao() : NoteDao
}