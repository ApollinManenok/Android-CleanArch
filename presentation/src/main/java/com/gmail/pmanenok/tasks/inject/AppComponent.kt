package com.gmail.pmanenok.tasks.inject

import com.gmail.pmanenok.tasks.app.App
import com.gmail.pmanenok.tasks.presentation.screen.student.list.StudentListViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class,
    RepositoryModule::class, PresentationModule::class, DataModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App) : Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

    fun inject(view: StudentListViewModel)
}