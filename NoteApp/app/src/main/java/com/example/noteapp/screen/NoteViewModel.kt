package com.example.noteapp.screen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.NotesDataSource
import com.example.noteapp.model.Note
import com.example.noteapp.repository.RepositoryNote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repo: RepositoryNote) : ViewModel() {
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllNote().distinctUntilChanged()
                .collect { listOfNotes ->
                    if (listOfNotes.isEmpty()) {

                    } else {
                        _noteList.value = listOfNotes
                    }
                }
        }
    }

     fun addNote(note: Note) = viewModelScope.launch { repo.addNote(note) }
     fun deleteNote(note: Note) = viewModelScope.launch { repo.deleteNote(note) }
     fun deleteAllNote() = viewModelScope.launch { repo.deleteAllNote() }
}