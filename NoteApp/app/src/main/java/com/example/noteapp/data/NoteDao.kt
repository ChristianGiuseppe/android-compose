package com.example.noteapp.data

import androidx.room.*
import com.example.noteapp.model.Note
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface NoteDao {

    //flow --> ci permette da una classe o da una funzione di ascoltare i cambiamenti
    @Query(value = "SELECT * from notes_tbl")
    fun getNotes(): Flow<List<Note>>

    @Query(value = "SELECT * from notes_tbl where id =:id")
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note:Note)

    @Query(value = "DELETE from notes_tbl")
    suspend fun deleteAllNote()

    @Delete
    suspend fun deleteNote(note: Note)

}