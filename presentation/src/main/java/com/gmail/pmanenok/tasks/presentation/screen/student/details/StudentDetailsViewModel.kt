package com.gmail.pmanenok.tasks.presentation.screen.student.details

import android.databinding.ObservableBoolean
import android.support.v7.widget.RecyclerView
import com.gmail.pmanenok.tasks.factories.UseCaseProvider
import com.gmail.pmanenok.tasks.presentation.base.BaseViewModel
import com.gmail.pmanenok.tasks.presentation.screen.student.StudentRouter
import io.reactivex.rxkotlin.subscribeBy

class StudentDetailsViewModel : BaseViewModel<StudentRouter>() {
    private var studentId: String? = null

    fun setStudentId(id: String) {
        if (studentId != null) return
        studentId = id
    }

    val isProgressEnabled = ObservableBoolean(false)

    //getStudentById()
    init {
    }
}