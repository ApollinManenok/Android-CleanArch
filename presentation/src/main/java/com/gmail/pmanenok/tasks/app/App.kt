package com.gmail.pmanenok.tasks.app

import android.app.Activity
import android.app.Application
import com.squareup.leakcanary.LeakCanary
import com.crashlytics.android.Crashlytics;
import com.gmail.pmanenok.tasks.inject.AppComponent
import com.gmail.pmanenok.tasks.inject.AppModule
import com.gmail.pmanenok.tasks.inject.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.fabric.sdk.android.Fabric;
import javax.inject.Inject


class App : Application(), HasActivityInjector{
    @Inject
    lateinit var  activityInjector: DispatchingAndroidInjector<Activity>

    companion object {

        lateinit var instance: App
        @JvmStatic
        lateinit var appComponent: AppComponent
    }
    init {
        instance = this
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

    override fun onCreate() {
        super.onCreate()
        /*if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this)*/
        appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()
            //.appModule(AppModule(this))


        Fabric.with(this, Crashlytics())
    }
}