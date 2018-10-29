package com.gmail.pmanenok.tasks.presentation.screen.student

import android.view.View
import com.gmail.pmanenok.tasks.R
import com.gmail.pmanenok.tasks.presentation.base.BaseRouter
import com.gmail.pmanenok.tasks.presentation.screen.student.details.StudentDetailsFragment
import com.gmail.pmanenok.tasks.presentation.screen.student.list.StudentListFragment

class StudentRouter(activity: StudentActivity) : BaseRouter<StudentActivity>(activity) {

    fun goToStudentList() {
        replaceFragment(
            activity.supportFragmentManager,
            StudentListFragment.getInstance(),
            R.id.student_container,
            false
        )
    }

    fun goToStudentDetails(id: String) {
        val containerDetails = activity.findViewById<View>(R.id.student_container_details)
        if (containerDetails == null) {
            replaceFragment(
                activity.supportFragmentManager,
                StudentDetailsFragment.getInstance(id),
                R.id.student_container,
                true
            )
        } else {
            replaceFragment(
                activity.supportFragmentManager,
                StudentDetailsFragment.getInstance(id),
                R.id.student_container_details,
                false
            )
        }

    }
}