package com.gmail.pmanenok.tasks.presentation.mvp

import com.gmail.pmanenok.domain.entity.student.StudentSearch
import com.gmail.pmanenok.tasks.factories.UseCaseProvider
import com.gmail.pmanenok.tasks.presentation.mvp.base.BasePresenter
import io.reactivex.rxkotlin.subscribeBy

class StudentPresenter(view: StudentView) : BasePresenter<StudentRouter, StudentView>(view) {
    private val searchStudentListUseCase = UseCaseProvider.provideSearchStudentUseCase()

    fun search(search: String) {
        view.showProgressBar()
        val studentSearch = StudentSearch(search)
        val disposable = searchStudentListUseCase.search(studentSearch).subscribeBy(
            onNext = {
                view.dismissProgressBar()
                view.showStudents(it)
            },
            onError = {
                view.dismissProgressBar()
                router?.showError(it)
            }
        )
        addToDisposable(disposable)
    }
}