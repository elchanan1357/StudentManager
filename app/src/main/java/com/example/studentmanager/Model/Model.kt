package com.example.studentmanager.Model

import android.util.Log

class Model private constructor() {
    companion object {
        val instance: Model = Model()
    }

    val students: MutableList<Student> = ArrayList()

    fun addStudent(newStudent: Student) {
        this.students.add(newStudent)
        Log.d("add","size of list: ${students.size}")
    }

    fun getStudent(i: Int): Student {
        return this.students[i]
    }

    fun editStudent(i: Int, newStudent: Student) {
        this.students.removeAt(i)
        this.students.add(i, newStudent)
    }

    fun removeStudent(i: Int) {
        this.students.removeAt(i)
    }
}