package com.gmail.pmanenok.tasks.inject

import com.gmail.pmanenok.tasks.presentation.mvp.StudentActivity
import com.gmail.pmanenok.tasks.presentation.screen.student.StudentModule
import com.gmail.pmanenok.tasks.presentation.screen.student.details.StudentDetailsFragment
import com.gmail.pmanenok.tasks.presentation.screen.student.details.StudentDetailsModule
import com.gmail.pmanenok.tasks.presentation.screen.student.list.StudentListFragment
import com.gmail.pmanenok.tasks.presentation.screen.student.list.StudentListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PresentationModule {
    @ContributesAndroidInjector(modules = [StudentModule::class])
    abstract fun studentModule():StudentActivity


}