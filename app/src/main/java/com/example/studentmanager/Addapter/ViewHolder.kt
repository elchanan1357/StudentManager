package com.example.studentmanager.Addapter

import android.annotation.SuppressLint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmanager.Model.Student
import com.example.studentmanager.R

class ViewHolder(rowView: View) : RecyclerView.ViewHolder(rowView) {
    private var name: TextView? = null
    private var id: TextView? = null
    private var checkBox: CheckBox? = null

    init {
        this.name = rowView.findViewById(R.id.Row_name)
        this.id = rowView.findViewById(R.id.Row_id)
        this.checkBox = rowView.findViewById(R.id.Row_chekbox)
    }

    @SuppressLint("SetTextI18n")
    fun bind(student: Student?, position: Int) {
        this.name?.text = "Name: ${student?.name}"
        this.id?.text = "ID: ${student?.id.toString()}"

        this.checkBox?.apply {
            isChecked = student?.isChecked ?: false
            tag = position
        }
    }
}