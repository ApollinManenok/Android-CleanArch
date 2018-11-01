package com.gmail.pmanenok.tasks.presentation.screen.student.details

import android.databinding.ObservableField
import android.util.Log
import android.view.View
import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.tasks.factories.UseCaseProvider
import com.gmail.pmanenok.tasks.presentation.base.BaseViewModel
import com.gmail.pmanenok.tasks.presentation.screen.student.StudentRouter
import io.reactivex.rxkotlin.subscribeBy

class StudentDetailsViewModel : BaseViewModel<StudentRouter>() {
    private var getStudentById = UseCaseProvider.provideGetStudentByIdUseCase()
    private var updateStudent = UseCaseProvider.provideUpdateStudentUseCase()
    private var deleteStudentById = UseCaseProvider.provideDeleteStudentUseCase()

    var name = ObservableField<String>("")
    var age = ObservableField<String>("")
    var gender = ObservableField<String>("")
    var imageUrl = ObservableField<String>("")
    var isMale = ObservableField<Boolean>(false)

    private var studentId: String = ""
    fun setStudentId(id: String) {
        if (studentId != "") return
        studentId = id
        setStudent()
    }

    //var item = ObservableField<Student>(Student(studentId, "", 0))

    private fun setStudent() {
        if (studentId != "") {
            val disposable = getStudentById.get(studentId).subscribeBy(
                onNext = {
                    name.set(it.name)
                    age.set(it.age.toString())
                    gender.set(it.gender)
                    imageUrl.set(it.imageUrl)
                    isMale.set(it.gender == "male")
                },
                onError = {
                    router?.showError(it)
                }
            )
            addToDisposable(disposable)
        }
    }

    fun onSaveClick(view: View) {
        Log.e("aaa", "StudentDetailsViewModel onSaveClick")
        updateStudent.update(
            Student(
                studentId, name.get().toString(), age.get().toString().toInt(),
                gender.get().toString(), imageUrl.get().toString()
            )
        )
        router?.goBackFromDetails()
    }

    fun onDeleteClick(view: View) {
        Log.e("aaa", "StudentDetailsViewModel onDeleteClick")
        deleteStudentById.delete(studentId)
        router?.goBackFromDetails()
    }

}