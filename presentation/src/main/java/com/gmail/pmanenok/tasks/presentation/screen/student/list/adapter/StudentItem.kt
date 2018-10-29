package com.gmail.pmanenok.tasks.presentation.screen.student.list.adapter

import android.databinding.ObservableField
import com.gmail.pmanenok.domain.entity.student.Student

class StudentItem(student: Student) {
    val id = ObservableField<String>(student.id)
    val fio = ObservableField<String>(student.name)
    val imageUrl = ObservableField<String>(student.imageUrl)
    val age = ObservableField<String>(student.age.toString())
    val gender = ObservableField<String>(student.gender)
    val isMale = ObservableField<Boolean>(student.gender == "male")
}