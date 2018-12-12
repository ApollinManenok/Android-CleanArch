package com.gmail.pmanenok.tasks.presentation.mvp

import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.tasks.presentation.mvp.base.BaseView

interface StudentView : BaseView {
    fun showProgressBar()
    fun dismissProgressBar()
    fun showStudents(studentList: List<Student>)
}