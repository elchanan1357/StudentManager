package com.example.studentmanager.Addapter

import android.annotation.SuppressLint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmanager.Model.Student
import com.example.studentmanager.R

class ViewHolder(rowView: View, listener: OnClickItemListener?) : RecyclerView.ViewHolder(rowView) {
    private var name: TextView? = null
    private var id: TextView? = null
    private var checkBox: CheckBox? = null
    private var student: Student? = null
    private var tag: Int? = null

    init {
        this.name = rowView.findViewById(R.id.Row_name)
        this.id = rowView.findViewById(R.id.Row_id)
        this.checkBox = rowView.findViewById(R.id.Row_chekbox)

        rowView.setOnClickListener {
            this.tag?.let { tag -> listener?.onItemClick(tag) }
        }
    }

    @SuppressLint("SetTextI18n")
    fun bind(s: Student?, position: Int) {
        this.student = s
        this.name?.text = "Name: ${s?.name}"
        this.id?.text = "ID: ${s?.id.toString()}"
        this.tag = position


        this.checkBox?.apply {
            isChecked = s?.isChecked ?: false
            tag = position
        }
    }
}