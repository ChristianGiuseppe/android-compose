package com.example.triviaapp.model

data class QuestionItem(
    val answer: String,
    val category: String,
    val choice: ArrayList<String>,
    val question: String
)