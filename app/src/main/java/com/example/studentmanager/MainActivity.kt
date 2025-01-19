package com.example.studentmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmanager.Addapter.RecycleViewAdapter
import com.example.studentmanager.Model.Model
import com.example.studentmanager.Model.Student

class MainActivity : AppCompatActivity() {
    private var students: MutableList<Student>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)

        onCreateRecycleView()
    }

    private fun onCreateRecycleView() {
        students = Model.instance.students
        val recycleView: RecyclerView = findViewById(R.id.Main_list)
        recycleView.setHasFixedSize(true)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = RecycleViewAdapter(students)
    }


}