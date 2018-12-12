package com.gmail.pmanenok.tasks.presentation.screen.menu

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.gmail.pmanenok.tasks.R
import com.gmail.pmanenok.tasks.databinding.ActivityMenuBinding
import com.gmail.pmanenok.tasks.presentation.base.BaseMvvmActivity
import com.gmail.pmanenok.tasks.presentation.screen.hw10.HW10Activity
import com.gmail.pmanenok.tasks.presentation.screen.hw9.HW9Activity
import com.gmail.pmanenok.tasks.presentation.screen.student.StudentActivity

class MenuActivity : BaseMvvmActivity<MenuViewModel, MenuRouter, ActivityMenuBinding>() {
    override fun prodiveViewModel(): MenuViewModel {
        return ViewModelProviders.of(this)
            .get(MenuViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.activity_menu

    override fun provideRouter(): MenuRouter {
        return MenuRouter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val btnHW9 = findViewById<Button>(R.id.btn_hw9)
        btnHW9.setOnClickListener {
            var intent = Intent(this@MenuActivity, HW9Activity::class.java)
            startActivity(intent)
        }
        val btnHW10 = findViewById<Button>(R.id.btn_hw10)
        btnHW10.setOnClickListener {
            var intent = Intent(this@MenuActivity, HW10Activity::class.java)
            startActivity(intent)
        }

        val btnStudent = findViewById<Button>(R.id.btn_student)
        btnStudent.setOnClickListener {
            var intent = Intent(this@MenuActivity, StudentActivity::class.java)
            startActivity(intent)
        }

    }
}
