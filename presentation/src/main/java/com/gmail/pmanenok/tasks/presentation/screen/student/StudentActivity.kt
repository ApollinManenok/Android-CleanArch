package com.gmail.pmanenok.tasks.presentation.screen.student

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.gmail.pmanenok.tasks.R
import com.gmail.pmanenok.tasks.databinding.ActivityStudentBinding
import com.gmail.pmanenok.tasks.presentation.base.BaseMvvmActivity
import io.reactivex.Observable
import io.reactivex.disposables.Disposable


class StudentActivity : BaseMvvmActivity<StudentViewModel, StudentRouter, ActivityStudentBinding>() {
    private lateinit var subscription: Disposable
    private lateinit var values: Observable<Long>


    override fun provideRouter(): StudentRouter {
        return StudentRouter(this)
    }

    override fun prodiveViewModel(): StudentViewModel {
        return ViewModelProviders.of(this)
            .get(StudentViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.activity_student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {//to not recreate fragments
            router.goToStudentList()
        }
    }
}

//object : Observer<Long> {
//                override fun onComplete() {
//                }//no more data
//
//                override fun onSubscribe(d: Disposable) {
//                    disposable = d
//                }//give something to unsubscribe
//
//                override fun onNext(v: Long) {
//                    Log.e("aaa", "Time: $v")
//                }//next value
//
//                override fun onError(e: Throwable) {
//                    Log.e("aaa", "onError() " + e.toString())
//                }//if some error
//
//            }
// override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
///*        viewModel.testText.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
//            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
//            }
//        })*/
//
//
//        //val values = Observable.interval(1, TimeUnit.SECONDS)
//        //subscription = values.subscribeBy({ Log.e("aaa", "onError() " + it.toString()) },
//        //    { Log.e("aaa", "onComplete()") },
//        //    { Log.e("aaa", "onNext() " + it) })
//
//    }
//val values = Observable.timer(10, TimeUnit.MILLISECONDS)
//subscription = values.subscribe(
//    { Log.e("aaa", "onNext() " + it) },
//    { Log.e("aaa", "onError() " + it.toString()) },
//    { Log.e("aaa", "onComplete()") }
//)
//timer