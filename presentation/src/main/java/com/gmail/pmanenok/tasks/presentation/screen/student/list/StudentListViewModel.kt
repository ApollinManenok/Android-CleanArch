package com.gmail.pmanenok.tasks.presentation.screen.student.list

import android.databinding.ObservableBoolean
import android.util.Log
import com.gmail.pmanenok.domain.entity.student.StudentSearch
import com.gmail.pmanenok.tasks.factories.UseCaseProvider
import com.gmail.pmanenok.tasks.presentation.base.BaseViewModel
import com.gmail.pmanenok.tasks.presentation.screen.student.StudentRouter
import com.gmail.pmanenok.tasks.presentation.screen.student.list.adapter.StudentListAdapter
import io.reactivex.rxkotlin.subscribeBy

class StudentListViewModel : BaseViewModel<StudentRouter>() {
    val adapter = StudentListAdapter { router?.goToStudentDetails(it.id) }
    val isProgressEnabled = ObservableBoolean(false)

    private var studentListUseCase = UseCaseProvider.provideGetStudentListUseCase()

    private var searchStudentListUseCase = UseCaseProvider.provideSearchStudentUseCase()

    init {
        Log.e("bbb", "StudentListViewModel init")
        isProgressEnabled.set(true)
        val disposable = studentListUseCase.get().subscribeBy(
            onNext = {
                Log.e("aaa", "StudentListViewModel onNext")
                isProgressEnabled.set(false)
                adapter.itemList = it// set data to adapter
            },
            onError = {
                isProgressEnabled.set(false)
                router?.showError(it)
            }
        )
        addToDisposable(disposable)
    }

    fun search(search: String) {
        Log.e("aaa", "StudentListViewModel search")
        if (isProgressEnabled.get()) return
        val studentSearch = StudentSearch(search)
        val disposable = searchStudentListUseCase.search(studentSearch).subscribeBy(
            onNext = {
                Log.e("aaa", "StudentListViewModel search onNext")
                adapter.itemList = it// set data to adapter
            },
            onError = { router?.showError(it) }
        )
        addToDisposable(disposable)
    }
}