package com.gmail.pmanenok.tasks.presentation.screen.hw9

import android.arch.lifecycle.ViewModelProviders

import com.gmail.pmanenok.tasks.R
import com.gmail.pmanenok.tasks.databinding.ActivityHw9Binding
import com.gmail.pmanenok.tasks.presentation.base.BaseMvvmActivity

class HW9Activity : BaseMvvmActivity<HW20ViewModel, HW20Router, ActivityHw9Binding>() {

    override fun prodiveViewModel(): HW20ViewModel {
        return ViewModelProviders.of(this)
            .get(HW20ViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.activity_hw9

    override fun provideRouter(): HW20Router {
        return HW20Router(this)
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