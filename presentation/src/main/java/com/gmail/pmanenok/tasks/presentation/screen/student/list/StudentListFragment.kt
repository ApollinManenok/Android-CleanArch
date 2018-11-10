package com.gmail.pmanenok.tasks.presentation.screen.student.list

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.gmail.pmanenok.tasks.R
import com.gmail.pmanenok.tasks.databinding.FragmentStudentListBinding
import com.gmail.pmanenok.tasks.presentation.base.BaseMvvmFragment
import com.gmail.pmanenok.tasks.presentation.screen.student.StudentRouter
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit

class StudentListFragment : BaseMvvmFragment<StudentListViewModel, StudentRouter, FragmentStudentListBinding>() {
    companion object {
        fun getInstance(): StudentListFragment {
            return StudentListFragment()
        }
    }

    override fun prodiveViewModel(): StudentListViewModel {
        return ViewModelProviders.of(this)
            .get(StudentListViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_student_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.e("bbb", "StudentListFragment onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        binding.listRecycleView.adapter = viewModel.adapter
        binding.listRecycleView.layoutManager = LinearLayoutManager(context)
        binding.listRecycleView.setHasFixedSize(true)
        RxTextView.textChanges(binding.searchEditText).throttleFirst(500L, TimeUnit.MILLISECONDS)
            .subscribeBy(
                onNext = {
                    Log.e("bbb", "StudentListFragment onViewCreated searching")
                    viewModel.search(it.toString())
                },
                onError = {
                    router?.showError(it)
                })
        binding.listFabAddStudent.setOnClickListener { router?.goToStudentDetails("") }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("bbb", "StudentListFragment onDestroy")
    }
}


//binding.search_edit_text.addTextChangedListener(object:TextWatcher{})
//after viewModel.search(p0.toString())
