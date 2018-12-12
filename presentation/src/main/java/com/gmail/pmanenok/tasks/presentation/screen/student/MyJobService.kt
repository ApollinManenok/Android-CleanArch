package com.gmail.pmanenok.tasks.presentation.screen.student

import android.app.job.JobParameters
import android.app.job.JobService
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class MyJobService :JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        Thread.sleep(1000)
        Log.e("MyJobService", "onStartJob")
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {

        Log.e("MyJobService", "onStopJob")
        return true
    }

}