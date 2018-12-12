package com.gmail.pmanenok.tasks.presentation.screen.student.list

import android.content.Context
import com.gmail.pmanenok.data.repositories.StudentRepositoryImplTestDb
import com.gmail.pmanenok.data.repositories.StudentRepositoryImplTestDb_Factory
import com.gmail.pmanenok.domain.executor.PostExecutorThread
import com.gmail.pmanenok.domain.usecases.GetStudentsUseCase
import com.gmail.pmanenok.domain.usecases.SearchStudentsUseCase
import com.gmail.pmanenok.tasks.app.App
import dagger.Module
import dagger.Provides

@Module
class StudentListModule {
    /*@Provides
    fun provideGetStudentsUseCase(postExecutorThread: PostExecutorThread, repositoryImplTestDb: StudentRepositoryImplTestDb): GetStudentsUseCase = GetStudentsUseCase(postExecutorThread, repositoryImplTestDb)
    @Provides
    fun provideSearchStudentsUseCase(postExecutorThread: PostExecutorThread, repositoryImplTestDb: StudentRepositoryImplTestDb): SearchStudentsUseCase = SearchStudentsUseCase(postExecutorThread, repositoryImplTestDb)*/
}