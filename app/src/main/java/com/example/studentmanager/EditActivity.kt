package com.example.studentmanager

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.studentmanager.Model.Model
import com.example.studentmanager.Model.Student

class EditActivity : AppCompatActivity() {

    private var name: EditText? = null
    private var id: EditText? = null
    private var phone: EditText? = null
    private var address: EditText? = null
    private lateinit var checkBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

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

        name?.setText(student.name)
        id?.setText(student.id.toString())
        phone?.setText(student.phone.toString())
        address?.setText(student.address)
        checkBox.isChecked = student.isChecked
    }

    private fun allClicks(i: Int) {
        findViewById<Button>(R.id.Edit_deleteBtn).setOnClickListener { remove(i) }
        findViewById<Button>(R.id.Edit_cancelBtn).setOnClickListener { finish() }
        findViewById<Button>(R.id.Edit_saveBtn).setOnClickListener { update(i) }
    }

    private fun remove(i: Int) {
        Model.instance.removeStudent(i)
        val intent = Intent(this, MainActivity::class.java) // MainActivity היא Activity A
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    private fun update(i: Int) {
        val student = Student(
            name?.text.toString(),
            id?.text.toString().toInt(),
            phone?.text.toString().toInt(),
            address?.text.toString(),
            checkBox.isChecked
        )
        Model.instance.editStudent(i, student)
        finish()
    }
}