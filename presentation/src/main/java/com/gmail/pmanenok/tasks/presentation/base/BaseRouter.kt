package com.gmail.pmanenok.tasks.presentation.base

import android.support.v4.app.FragmentManager
import android.util.Log
import android.widget.Toast

abstract class BaseRouter<A : BaseActivity>(val activity: A) {

    fun popBackStack() {
        activity.supportFragmentManager.popBackStack()
    }

    fun goBack() {
        activity.onBackPressed()
    }

    fun showError(e: Throwable) {
        Log.e("Error in Router", e.message)
        Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
    }

    fun replaceFragment(
        fragmentManager: FragmentManager,
        fragment: BaseFragment,
        containerResId: Int,
        addToBackStack: Boolean = false
    ) {
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(containerResId, fragment, fragment::class.java.canonicalName)
        if (addToBackStack) {
            fragmentTransition.addToBackStack(null)
        }
        fragmentTransition.commit()
    }
}