package com.gmail.pmanenok.tasks.presentation.screen.student.list.binding

import android.view.LayoutInflater
import android.view.ViewGroup
import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.tasks.databinding.ItemStudentBindListBinding
import com.gmail.pmanenok.tasks.databinding.ItemStudentListBinding
import com.gmail.pmanenok.tasks.presentation.base.recycler.BaseViewHolder
import com.gmail.pmanenok.tasks.presentation.screen.student.StudentViewModel

class StudentItemViewHolder(binding: ItemStudentBindListBinding, viewModel: StudentItemViewModel) :
    BaseViewHolder<Student, StudentItemViewModel, ItemStudentBindListBinding>(binding, viewModel) {
    companion object {
        fun create(parent: ViewGroup, viewModel: StudentItemViewModel): StudentItemViewHolder {
            val binding = ItemStudentBindListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return StudentItemViewHolder(binding, viewModel)
        }
    }
}