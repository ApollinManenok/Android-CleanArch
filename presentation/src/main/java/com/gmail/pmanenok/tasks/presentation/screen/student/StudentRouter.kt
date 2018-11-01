package com.gmail.pmanenok.tasks.presentation.screen.student

import android.view.View
import com.gmail.pmanenok.tasks.R
import com.gmail.pmanenok.tasks.presentation.base.BaseRouter
import com.gmail.pmanenok.tasks.presentation.screen.student.details.StudentDetailsFragment
import com.gmail.pmanenok.tasks.presentation.screen.student.list.StudentListFragment

class StudentRouter(activity: StudentActivity) : BaseRouter<StudentActivity>(activity) {

    fun goBackFromDetails() {
        val containerDetails = activity.findViewById<View>(R.id.student_container_details)
        if (containerDetails == null) {
            popBackStack()
        } else {
            val transaction = activity.supportFragmentManager.beginTransaction()
            val frag = activity.supportFragmentManager.findFragmentByTag(StudentListFragment::class.java.canonicalName)
            val fragDetail =
                activity.supportFragmentManager.findFragmentByTag(StudentDetailsFragment::class.java.canonicalName)
            if (frag != null && fragDetail != null) {
                transaction.detach(frag)
                transaction.detach(fragDetail)
                transaction.attach(frag)
            }
            transaction.commit()
        }
    }

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