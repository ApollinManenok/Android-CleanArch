package com.gmail.pmanenok.tasks.presentation.mvp

import android.content.Context
import android.content.Intent
import android.view.View
import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.tasks.R
import com.gmail.pmanenok.tasks.presentation.mvp.base.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_student_mvp.*

class StudentActivity : BaseMvpActivity<StudentPresenter, StudentRouter>(), StudentView {
    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, javaClass)
        }
    }

    override fun showProgressBar() {
        progress_bar_mvp.visibility = View.VISIBLE
    }

    override fun dismissProgressBar() {
        progress_bar_mvp.visibility = View.INVISIBLE
    }

    override fun showStudents(studentList: List<Student>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun providePresenter(): StudentPresenter {
        return StudentPresenter(this)
    }

    override fun provideRouter(): StudentRouter {
        return StudentRouter(this)
    }

    override fun provideLayoutId(): Int {
        return R.layout.activity_student_mvp
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onPause() {
        super.onPause()
        presenter.removeRouter()
        presenter.onPause()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
        presenter.addRouter(router)
    }
}