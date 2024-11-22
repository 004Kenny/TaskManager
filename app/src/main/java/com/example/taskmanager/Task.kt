package com.example.taskmanager

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val dueDate: String,
    val dueTime: String,
    val priority: String,
    val status: String,
    val reminders: String?,
    val creationDate: String
)
