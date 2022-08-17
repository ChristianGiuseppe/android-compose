package com.example.noteapp.repository

import com.example.noteapp.data.NoteDao
import com.example.noteapp.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryNote @Inject constructor(private val noteDao: NoteDao) {

    suspend fun addNote(note: Note) = noteDao.insert(note)

    suspend fun updateNote(note: Note) = noteDao.update(note)

    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)

    suspend fun deleteAllNote() = noteDao.deleteAllNote()

    suspend fun getAllNote(): Flow<List<Note>> = noteDao.getNotes().flowOn(Dispatchers.IO).conflate()


}