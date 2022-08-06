package com.example.noteapp.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.noteapp.R
import com.example.noteapp.component.NoteButton
import com.example.noteapp.component.NoteInputText
import com.example.noteapp.model.Note
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteScreen(
    listNotes: List<Note>,
    addNote: (Note) -> Unit,
    removeNote: (Note) -> Unit,

){
    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    Column {
        TopAppBar (
            title = {
            Text(text = stringResource(id = R.string.app_name), color = Color.White)
        },
            actions = {
                Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "Notification" )
            },

            backgroundColor = Color(0xFFDFAE00)
        )
        
        // content
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

            NoteInputText(modifier =  Modifier.padding(top= 12.dp, bottom = 12.dp), text = title, label = "Title", maxLine = 1, onTextChange ={
                if(it.all{ char ->
                        char.isLetter() || char.isWhitespace()
                    }) title = it
            } )

            NoteInputText(modifier =  Modifier.padding(top= 12.dp, bottom = 12.dp), text = description, label = "Add a Note", maxLine = 3, onTextChange = {
                if(it.all{ char ->
                        char.isLetter() || char.isWhitespace()
                    }) description = it
            })

            NoteButton(modifier =  Modifier.padding(top= 12.dp, bottom = 12.dp),text = "Save", onClick = {
                if (title.isNotEmpty() && description.isNotEmpty()){
                    addNote(Note(title= title, description = description));
                    title = ""
                    description= ""
                }
            })


            Divider(modifier = Modifier.padding(10.dp))

            LazyColumn{
                this.items(listNotes){ note ->
                       NoteRow(note = note, onNoteClick =  {
                           removeNote(note);
                       })

                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClick : (Note) -> Unit
){
    Surface(
        modifier
            .padding(start = 8.dp, end = 8.dp, top = 4.dp,  bottom =  4.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(),
        color = Color(0xFFDFAE00),
        elevation = 4.dp
    ) {
        Column(
            modifier
                .clickable {
                    onNoteClick(note)
                }
                .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.Start) {
            Text(text = note.title, style = MaterialTheme.typography.subtitle2, color = Color.White)
            Text(text = note.description, style = MaterialTheme.typography.subtitle1, color = Color.White)
            Text(text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")), style = MaterialTheme.typography.caption, color = Color.White)
        }
    }
}
