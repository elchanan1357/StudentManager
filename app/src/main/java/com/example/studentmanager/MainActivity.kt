package com.example.studentmanager

import android.annotation.SuppressLint

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmanager.Addapter.OnClickItemListener
import com.example.studentmanager.Addapter.RecycleViewAdapter
import com.example.studentmanager.Model.Model
import com.example.studentmanager.Model.Student

class MainActivity : AppCompatActivity() {
    private var students: MutableList<Student>? = null
    private  var adapter:RecycleViewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = ContextCompat.getColor(this, R.color.silver)

        onCreateRecycleView()
        allClicks()
    }

    private fun onCreateRecycleView() {
        students = Model.instance.students
        val recycleView: RecyclerView = findViewById(R.id.Main_list)
        recycleView.setHasFixedSize(true)
        recycleView.layoutManager = LinearLayoutManager(this)
        adapter = RecycleViewAdapter(students)
        recycleView.adapter = adapter
    }

    private fun allClicks(){
        findViewById<Button>(R.id.Main_addBtn).setOnClickListener {
            val intent = Intent(this, AddStudent::class.java)
            startActivity(intent)
        }

        val intent = Intent(this, DetailsActivity::class.java)
        adapter?.listener =  object : OnClickItemListener {
            override fun onItemClick(position: Int) {
                intent.putExtra("Position",position)
                startActivity(intent)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        adapter?.notifyDataSetChanged()
    }

}