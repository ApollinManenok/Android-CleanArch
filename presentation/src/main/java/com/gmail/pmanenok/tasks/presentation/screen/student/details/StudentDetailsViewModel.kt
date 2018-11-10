package com.gmail.pmanenok.tasks.presentation.screen.student.details

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.util.Log
import android.view.View
import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.tasks.factories.UseCaseProvider
import com.gmail.pmanenok.tasks.presentation.base.BaseViewModel
import com.gmail.pmanenok.tasks.presentation.screen.student.StudentRouter
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit

class StudentDetailsViewModel : BaseViewModel<StudentRouter>() {
    private var getStudentById = UseCaseProvider.provideGetStudentByIdUseCase()
    private var updateStudent = UseCaseProvider.provideUpdateStudentUseCase()
    private var deleteStudentById = UseCaseProvider.provideDeleteStudentUseCase()

    var name = ObservableField<String>("")
    var age = ObservableField<String>("")
    var gender = ObservableField<String>("")
    var imageUrl = ObservableField<String>("")
    var isMale = ObservableBoolean(false)

    private var studentId: String = ""
    fun setStudentId(id: String) {
        if (studentId != "") return
        studentId = id
        setStudent()
    }

    private fun setStudent() {
        if (studentId != "") {
            addToDisposable(getStudentById.get(studentId).subscribeBy(
                onNext = {
                    name.set(it.name)
                    age.set(Integer.toString(it.age))
                    gender.set(it.gender)
                    imageUrl.set(it.imageUrl)
                    isMale.set(it.gender == "male")
                },
                onError = {
                    router?.showError(it)
                }
            ))
        }
    }

    fun onSaveClick(view: View) {
        Log.e("aaa", "StudentDetailsViewModel onSaveClick")
        if (checkParams(name.get().toString(), age.get().toString(), gender.get().toString())) {
            if (studentId == "") {
                updateStudent.save(createStudent()).blockingAwait(1, TimeUnit.SECONDS)
            } else {
                updateStudent.update(createStudent()).blockingAwait(1, TimeUnit.SECONDS)
            }
            router?.goBackFromDetails()
        }
    }

    private fun checkParams(name: String, age: String, gender: String): Boolean {
        if (name.isBlank()) {
            router?.showError("Student name is blank!")
            return false
        } else if (age.isBlank() || age.toIntOrNull() == null) {
            router?.showError("Student age is blank or not a number!")
            return false
        } else if (gender.isBlank() || gender == "female" || gender == "male" || gender == "Female" || gender == "Male") {
            return true
        }
        router?.showError("Student gender must be female or male(Female/Male)!")
        return false
    }

    private fun createStudent(): Student {
        val stName: String = name.get().toString()
        val stAge: Int = Integer.valueOf(age.get().toString())
        val stGender: String = gender.get().toString()
        val stImgUrl: String = imageUrl.get().toString()

        if (stGender.isBlank() && stImgUrl.isBlank()) return Student(studentId, stName, stAge)
        else if (stGender.isBlank()) return Student(studentId, stName, stAge, imageUrl = stImgUrl)
        else if (stImgUrl.isBlank()) return Student(studentId, stName, stAge, stGender)
        else return Student(studentId, stName, stAge, stGender, stImgUrl)
    }

    fun onDeleteClick(view: View) {
        Log.e("aaa", "StudentDetailsViewModel onDeleteClick")
        deleteStudentById.delete(studentId).blockingAwait(1, TimeUnit.SECONDS)
        /*else */router?.goBackFromDetails()
    }

}