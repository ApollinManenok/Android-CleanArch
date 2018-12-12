package com.gmail.pmanenok.tasks.presentation.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentActivity
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity : FragmentActivity() {
    protected val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    protected fun addToDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        //AndroidInjection.inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}