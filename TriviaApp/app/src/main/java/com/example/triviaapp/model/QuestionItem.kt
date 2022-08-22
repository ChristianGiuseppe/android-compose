package com.example.triviaapp.model

data class QuestionItem(
    val answer: String,
    val category: String,
    val choices: ArrayList<String>,
    val question: String
)