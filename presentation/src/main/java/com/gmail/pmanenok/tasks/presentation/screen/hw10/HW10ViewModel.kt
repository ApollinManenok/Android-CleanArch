package com.gmail.pmanenok.tasks.presentation.screen.hw10

import android.databinding.ObservableField
import com.gmail.pmanenok.domain.entity.user.UserData
import com.gmail.pmanenok.tasks.presentation.base.BaseViewModel

class HW10ViewModel() : BaseViewModel<HW10Router>() {
    val data = ObservableField<UserData>(
        UserData(
            fio = "Jane Smith",
            imageUrl = "http://www.androidwallpper.com/wp-content/uploads/2017/02/High-Resolution-4K-Wallpaper-Phone-Wallpapers-V4KU.jpg",
            age = "24",
            gender = "female"
        )
    )
    val isMale = ObservableField<Boolean>(data.get()?.gender == "male")

    fun onResume() {

    }

    fun onPause() {

    }
}