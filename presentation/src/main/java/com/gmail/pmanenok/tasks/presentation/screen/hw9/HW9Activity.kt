package com.gmail.pmanenok.tasks.presentation.screen.hw9

import android.arch.lifecycle.ViewModelProviders

import com.gmail.pmanenok.tasks.R
import com.gmail.pmanenok.tasks.databinding.ActivityHw9Binding
import com.gmail.pmanenok.tasks.presentation.base.BaseMvvmActivity

class HW9Activity : BaseMvvmActivity<HW9ViewModel, HW9Router, ActivityHw9Binding>() {

    override fun prodiveViewModel(): HW9ViewModel {
        return ViewModelProviders.of(this)
            .get(HW9ViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.activity_hw9

    override fun provideRouter(): HW9Router {
        return HW9Router(this)
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }
}