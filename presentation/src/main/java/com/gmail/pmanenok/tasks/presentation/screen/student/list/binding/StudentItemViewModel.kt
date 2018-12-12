package com.gmail.pmanenok.tasks.presentation.screen.student.list.binding

import android.databinding.ObservableField
import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.tasks.presentation.base.recycler.BaseItemViewModel

class StudentItemViewModel : BaseItemViewModel<Student>() {
    val id = ObservableField<String>("")
    val fio = ObservableField<String>("")
    val imageUrl = ObservableField<String>("")
    val age = ObservableField<String>("")
    val gender = ObservableField<String>("")
    val isMale = ObservableField<Boolean>(true)

    override fun bindItem(item: Student, position: Int) {
        id.set(item.id)
        fio.set(item.name)
        imageUrl.set(item.imageUrl)
        age.set(item.age.toString())
        gender.set(item.gender)
        isMale.set(item.gender == "male")
    }
}