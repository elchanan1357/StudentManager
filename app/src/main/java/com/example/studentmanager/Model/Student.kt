package com.example.studentmanager.Model

import android.location.Address
import android.provider.ContactsContract.CommonDataKinds.Phone

data class Student(
    val name: String,
    val id: Number,
    val phone: Number,
    val address: String,
    val isChecked: Boolean
)
