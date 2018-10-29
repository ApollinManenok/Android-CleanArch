package com.gmail.pmanenok.tasks.presentation.screen.hw9

import android.databinding.ObservableField
import android.util.Log
import com.gmail.pmanenok.tasks.presentation.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit

class HW9ViewModel() : BaseViewModel<HW9Router>() {
    val timer = ObservableField<String>("Hello from HW9ViewModel")

    private var disposable: Disposable? = null
    private var observable: Observable<Long>

    init {
        Log.e("aaa", "init")
        observable = Observable.interval(1, TimeUnit.SECONDS)
            .filter { value -> (value % 2).toInt() == 0 }
    }

    fun onResume() {
        disposable = observable.subscribeBy(
            onNext = { value ->
                timer.set(value.toString())
            },
            onError = {
                Log.e("Error", it.message)
            })
    }

    fun onPause() {
        disposable?.dispose()
    }
}

