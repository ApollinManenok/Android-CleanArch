package com.gmail.pmanenok.tasks.presentation.screen.student

import android.content.Context
import com.gmail.pmanenok.tasks.app.App
import com.gmail.pmanenok.tasks.presentation.screen.student.details.StudentDetailsFragment
import com.gmail.pmanenok.tasks.presentation.screen.student.details.StudentDetailsModule
import com.gmail.pmanenok.tasks.presentation.screen.student.list.StudentListFragment
import com.gmail.pmanenok.tasks.presentation.screen.student.list.StudentListModule
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class StudentModule {
    /*@Module
    companion object {
        @Provides
        fun provideContext(app: App): Context = app.applicationContext
    }*/

    @ContributesAndroidInjector(modules = [StudentListModule::class])
    abstract fun studentListModule(): StudentListFragment

    @ContributesAndroidInjector(modules = [StudentDetailsModule::class])
    abstract fun studentDetailsModule(): StudentDetailsFragment
}