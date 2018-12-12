package com.gmail.pmanenok.tasks.presentation.mvp.base

import android.os.Bundle
import com.gmail.pmanenok.tasks.presentation.base.BaseActivity
import com.gmail.pmanenok.tasks.presentation.base.BaseRouter

abstract class BaseMvpActivity<P : BasePresenter<R, *>, R : BaseRouter<*>> : BaseActivity() {

    protected lateinit var presenter: P
    public lateinit var router: R

    abstract fun providePresenter(): P
    abstract fun provideRouter(): R
    abstract fun provideLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        router = provideRouter()
        presenter = providePresenter()
    }

}