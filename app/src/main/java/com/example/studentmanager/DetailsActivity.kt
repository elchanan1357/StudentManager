package com.example.studentmanager

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.studentmanager.Model.Model
import com.example.studentmanager.Model.Student

class DetailsActivity : AppCompatActivity() {
    var i: Int = -1

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        i = intent.getIntExtra("Position", -1)
        if (i != -1)
            presentStudent(i)
        else return


        findViewById<Button>(R.id.Detalis_EditBtn).setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("Position", i)
            startActivity(intent)
        }
    }

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    private fun presentStudent(i: Int) {
        val student = Model.instance.getStudent(i)

        val name = findViewById<TextView>(R.id.Detalis_name)
        val id = findViewById<TextView>(R.id.Detalis_id)
        val phone = findViewById<TextView>(R.id.Detalis_phone)
        val address = findViewById<TextView>(R.id.Detalis_address)
        val checkBox = findViewById<CheckBox>(R.id.Detalis_checkbox)

        name.text = "Name: ${student.name}"
        id.text = "ID: ${student.id.toString()}"
        phone.text = "Phone: ${student.phone.toString()}"
        address.text = "Address: ${student.address}"
        checkBox.isChecked = student.isChecked ?: false
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        i = intent.getIntExtra("Position", -1)
        if (i != -1)
            presentStudent(i)
    }
}