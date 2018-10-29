package com.gmail.pmanenok.tasks.presentation.screen.hw10

import android.arch.lifecycle.ViewModelProviders
import com.gmail.pmanenok.tasks.R
import com.gmail.pmanenok.tasks.databinding.ActivityHw10Binding
import com.gmail.pmanenok.tasks.presentation.base.BaseMvvmActivity

class HW10Activity : BaseMvvmActivity<HW10ViewModel, HW10Router, ActivityHw10Binding>() {

    override fun prodiveViewModel(): HW10ViewModel {
        return ViewModelProviders.of(this)
            .get(HW10ViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.activity_hw10

    override fun provideRouter(): HW10Router {
        return HW10Router(this)
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