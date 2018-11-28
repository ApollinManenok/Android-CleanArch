package com.gmail.pmanenok.tasks.presentation.base

import android.support.v4.app.FragmentManager
import android.util.Log
import android.widget.Toast
import com.gmail.pmanenok.domain.entity.AppErrorType
import com.gmail.pmanenok.domain.entity.AppException

abstract class BaseRouter<A : BaseActivity>(val activity: A) {

    fun popBackStack() {
        activity.supportFragmentManager.popBackStack()
    }

    fun goBack() {
        activity.onBackPressed()
    }

    fun showError(e: Throwable) {
        if (e is AppException) {
            val message = when (e.errorType) {
                AppErrorType.INTERNET_IS_NOT_AVAILABLE -> {
                    "Internet is not available"
                }
                AppErrorType.SERVER_IS_NOT_AVAILABLE -> {
                    "Server is not available"
                }
                else -> {
                    "Internet is not available"
                }
            }
            Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
            Log.e("Error in Router", message)
        } else {
            Log.e("Error in Router", e.message)
            Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
        }
    }

    fun showError(message: String) {
        Log.e("Error in Router", message)
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
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