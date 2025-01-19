package com.example.studentmanager.Model
import java.io.Serializable

data class Student(
    val name: String,
    val id: Number,
    val phone: Number,
    val address: String,
    val isChecked: Boolean
): Serializable
