package com.example.studentmanager

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.studentmanager.Model.Model
import com.example.studentmanager.Model.Student

class EditActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var id: EditText
    private lateinit var phone: EditText
    private lateinit var address: EditText
    private lateinit var checkBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        window.statusBarColor = ContextCompat.getColor(this, R.color.silver)

        init()
        val i = intent.getIntExtra("Position", -1)
        if (i != -1) {
            presentStudent(i)
            allClicks(i)
        } else return
    }

    private fun init() {
        id = findViewById(R.id.Edit_id)
        phone = findViewById(R.id.Edit_phone)
        address = findViewById(R.id.Edit_address)
        checkBox = findViewById(R.id.Edit_checkbox)
        name = findViewById(R.id.Edit_Name)
    }

    private fun presentStudent(i: Int) {
        val student = Model.instance.getStudent(i)

        name.setText(student.name)
        id.setText(student.id.toString())
        phone.setText(student.phone.toString())
        address.setText(student.address)
        checkBox.isChecked = student.isChecked
    }

    private fun allClicks(i: Int) {
        findViewById<Button>(R.id.Edit_deleteBtn).setOnClickListener { remove(i) }
        findViewById<Button>(R.id.Edit_cancelBtn).setOnClickListener { finish() }
        findViewById<Button>(R.id.Edit_saveBtn).setOnClickListener { update(i) }
    }

    private fun remove(i: Int) {
        Model.instance.removeStudent(i)
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    private fun update(i: Int) {
        if (name.text.isEmpty() || id.text.isEmpty() || phone.text.isEmpty()) {
            name.error = "This field is required"
            id.error = "This field is required"
            phone.error = "This field is required"
            return
        }

        val student = Student(
            name.text.toString(),
            id.text.toString().toInt(),
            phone.text.toString().toInt(),
            address.text.toString(),
            checkBox.isChecked
        )

        Model.instance.editStudent(i, student)
        finish()
    }
}