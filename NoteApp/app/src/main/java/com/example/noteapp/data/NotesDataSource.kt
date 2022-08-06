package com.example.noteapp.data

import com.example.noteapp.model.Note

class NotesDataSource {
    fun loadNotes():  List<Note> {
        return listOf(
            Note(title = "Note 1", description = "Descrizione della Note 1"),
            Note(title = "Note 2", description = "Descrizione della Note 2"),
            Note(title = "Note 3", description = "Descrizione della Note 3"),
            Note(title = "Note 4", description = "Descrizione della Note 4"),
            Note(title = "Note 5", description = "Descrizione della Note 5"),
            Note(title = "Note 6", description = "Descrizione della Note 6"),
            Note(title = "Note 7", description = "Descrizione della Note 7"),
            Note(title = "Note 8", description = "Descrizione della Note 8")

        )
    }
}