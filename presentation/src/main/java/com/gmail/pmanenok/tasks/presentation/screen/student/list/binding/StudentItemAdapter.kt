package com.gmail.pmanenok.tasks.presentation.screen.student.list.binding

import android.view.ViewGroup
import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.tasks.presentation.base.recycler.BaseRecyclerAdapter
import com.gmail.pmanenok.tasks.presentation.base.recycler.BaseViewHolder

class StudentItemAdapter : BaseRecyclerAdapter<Student,StudentItemViewModel>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): StudentItemViewHolder {
        return StudentItemViewHolder.create(viewGroup,  StudentItemViewModel())
    }
}