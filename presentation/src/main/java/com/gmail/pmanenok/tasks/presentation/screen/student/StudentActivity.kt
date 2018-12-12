package com.gmail.pmanenok.tasks.presentation.screen.student

import android.Manifest
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.arch.lifecycle.ViewModelProviders
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import com.gmail.pmanenok.tasks.R
import com.gmail.pmanenok.tasks.databinding.ActivityStudentBinding
import com.gmail.pmanenok.tasks.presentation.base.BaseMvvmActivity
import com.gmail.pmanenok.tasks.presentation.utils.checkActivityResult
import com.gmail.pmanenok.tasks.presentation.utils.startCamera
import com.tbruyelle.rxpermissions2.RxPermissions
import javax.inject.Inject


class StudentActivity : BaseMvvmActivity<StudentViewModel, StudentRouter, ActivityStudentBinding>() {
    @Inject
    override lateinit var viewModel: StudentViewModel

    @Inject
    override lateinit var router: StudentRouter

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
        /*val rxPermissions = RxPermissions(this)
        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE)
            .subscribe { granted ->
                if (granted) startCamera(this)
            }*/

        val componentName = ComponentName(this, MyJobService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val jobInfo = JobInfo.Builder(123, componentName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setRequiresCharging(true).build()
            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                jobInfo.setRequiresBatteryNotLow(true)
            }*/
            val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
            val result = jobScheduler.schedule(jobInfo)
            if(result == JobScheduler.RESULT_SUCCESS){
                Log.e("Job","Succes")
            }
        }
        /*val locationService = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        //locationService.getLastKnownLocation()
        val locationListener = object : LocationListener{
            override fun onLocationChanged(location: Location?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onProviderEnabled(provider: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onProviderDisabled(provider: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
        //locationService.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0f, locationListener)
        //locationService.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, locationListener)*/

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val file = checkActivityResult(this, requestCode, resultCode, data)
        if (file != null) {

        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}


//private lateinit var subscription: Disposable
//private lateinit var values: Observable<Long>
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