package com.example.studentmanager

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.studentmanager.Model.Model
import com.example.studentmanager.Model.Student

class AddStudent : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        findViewById<Button>(R.id.Add_SaveBtn).setOnClickListener { save() }
        findViewById<Button>(R.id.Add_CancelBtn).setOnClickListener { finish() }

    }

    private fun save() {
        val name: EditText = findViewById(R.id.Add_Name)
        val id: EditText = findViewById(R.id.Add_id)
        val phone: EditText = findViewById(R.id.Add_phone)
        val address: EditText = findViewById(R.id.Add_address)
        val checkBox: CheckBox = findViewById(R.id.Add_checkbox)

        if (name.text.isEmpty() || id.text.isEmpty() || phone.text.isEmpty() || address.text.isEmpty()) {
            Log.d("save", "Please fill all fields")
            return
        }

        val student: Student = Student(
            name.text.toString(), id.text.toString().toInt(), phone.text.toString().toInt(),
            address.text.toString(), checkBox.isChecked
        )
        Model.instance.addStudent(student)
        finish()
    }
}