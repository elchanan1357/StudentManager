package com.example.studentmanager

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.studentmanager.Model.Student

class DetailsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val student = intent.getSerializableExtra("student") as? Student

        val name = findViewById<TextView>(R.id.Detalis_name)
        val id = findViewById<TextView>(R.id.Detalis_id)
        val phone = findViewById<TextView>(R.id.Detalis_phone)
        val address = findViewById<TextView>(R.id.Detalis_address)
        val checkBox = findViewById<CheckBox>(R.id.Detalis_checkbox)

        name.text = "Name: ${student?.name}"
        id.text = "ID: ${student?.id.toString()}"
        phone.text = "Phone: ${student?.phone.toString()}"
        address.text = "Address: ${student?.address}"
        checkBox.isChecked = student?.isChecked ?: false
    }
}