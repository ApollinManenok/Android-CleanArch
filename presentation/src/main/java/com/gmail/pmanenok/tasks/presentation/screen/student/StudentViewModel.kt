package com.gmail.pmanenok.tasks.presentation.screen.student

import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.util.Log
import com.gmail.pmanenok.tasks.factories.UseCaseProvider
import com.gmail.pmanenok.tasks.presentation.base.BaseViewModel
import io.reactivex.rxkotlin.subscribeBy


class StudentViewModel() : BaseViewModel<StudentRouter>() {
//    private val getStudentUseCase = UseCaseProvider.provideGetStudentListUseCase()
//    private val searchStudentUseCase = UseCaseProvider.provideSearchStudentUseCase()

    //val studentSize = ObservableField<String>("No data")

    //val testText = ObservableField<String>("Hello from MVVM")
    //val testInt = ObservableInt(1)

}

//addToDisposable(
//            getStudentUseCase.get().subscribeBy(
//                onNext = { studentSize.set("studentList.size() = ${it.size}") },
//                onError = {
//                    studentSize.set("Error = " + it.toString())
//                    router?.showError(it)
//                })
//        )
//        //val listStudents = getStudentUseCase.get()

//private val publishSubject: PublishSubject<String> = PublishSubject.create() // only after subscribe
//    private val behaviorSubject: BehaviorSubject<String> = BehaviorSubject.create() // one before and all after subscribe
//    private val replaySubject: ReplaySubject<String> = ReplaySubject.create() // all before and after subscribe

//private var disposable: Disposable? = null ///disposable?.dispose()


//publishSubject.onNext("Item 1")
//publishSubject.onNext("Item 2")
//
//disposable = publishSubject.subscribeBy {
//    Log.e("aaa", "PublishSubject() " + it)
//}
//publishSubject.onNext("Item 3")
//publishSubject.onNext("Item 4")
//publishSubject.onNext("Item 5")

//

//object : Observer<String> {
//            override fun onComplete() {
//                Log.e("aaa", "onComplete()")
//            }//no more data
//
//            override fun onSubscribe(d: Disposable) {
//                disposable = d
//                Log.e("aaa", "onSubscribe()")
//            }//give something to unsubscribe
//
//            override fun onNext(t: String) {
//                Log.e("aaa", "onNext() " + t)
//            }//next value
//
//            override fun onError(e: Throwable) {
//                Log.e("aaa", "onError() " + e.toString())
//            }//if some error
//
//        }

// disposable = Observable.just("Hello", "World", "!")
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribeBy({ Log.e("aaa", "onError() " + it.toString()) },
//                { Log.e("aaa", "onComplete()") },
//                { Log.e("aaa", "onNext() " + it) })