package com.gmail.pmanenok.tasks.presentation.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.util.Log
import com.gmail.pmanenok.tasks.BR

abstract class BaseMvvmActivity<VM : BaseViewModel<R>,
        R : BaseRouter<*>, B : ViewDataBinding> : BaseActivity() {

    protected open lateinit var viewModel: VM
    protected lateinit var binding: B
    open lateinit var router: R


    abstract fun prodiveViewModel(): VM

    abstract fun provideLayoutId(): Int

    abstract fun provideRouter(): R

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = prodiveViewModel()
        binding = DataBindingUtil.setContentView(this, provideLayoutId())
        binding.setVariable(BR.viewModel, viewModel)
        router = provideRouter()
    }

    override fun onResume() {
        super.onResume()
        viewModel.addRouter(router)
    }

    override fun onPause() {
        super.onPause()
    }
}