package com.example.noteapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


//così può essere utilizzato ovunque

@HiltAndroidApp
class NoteApplication : Application() {

}