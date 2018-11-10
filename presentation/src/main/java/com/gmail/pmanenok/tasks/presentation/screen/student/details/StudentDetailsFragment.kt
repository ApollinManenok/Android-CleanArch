package com.gmail.pmanenok.tasks.presentation.screen.student.details

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.gmail.pmanenok.tasks.R
import com.gmail.pmanenok.tasks.databinding.FragmentStudentDetailsBinding
import com.gmail.pmanenok.tasks.presentation.base.BaseMvvmFragment
import com.gmail.pmanenok.tasks.presentation.screen.student.StudentRouter

class StudentDetailsFragment :
    BaseMvvmFragment<StudentDetailsViewModel, StudentRouter, FragmentStudentDetailsBinding>() {
    companion object {
        private const val ID_EXTRA = "ID_EXTRA"
        fun getInstance(id: String = ""): StudentDetailsFragment {
            val fragment = StudentDetailsFragment()
            val bundle = Bundle()
            bundle.putString(ID_EXTRA, id)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun prodiveViewModel(): StudentDetailsViewModel {
        return ViewModelProviders.of(this)
            .get(StudentDetailsViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_student_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString(ID_EXTRA)
        if (id != null) {
            viewModel.setStudentId(id)
        } else {
            router?.goBack()
        }
    }
}