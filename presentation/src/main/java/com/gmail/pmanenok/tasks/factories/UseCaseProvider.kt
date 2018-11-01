package com.gmail.pmanenok.tasks.factories

import com.gmail.pmanenok.data.net.RestService
import com.gmail.pmanenok.data.repositories.StudentRepositoryImpl
import com.gmail.pmanenok.domain.usecases.*
import com.gmail.pmanenok.tasks.executor.UIThread

object UseCaseProvider {

    val uiThread = UIThread()
    val restService = RestService("http://student")
    //val repository = StudentRepositoryImpl(restService)
    val repository = StudentRepositoryImpl()


    fun provideGetStudentListUseCase(): GetStudentsUseCase {
        return GetStudentsUseCase(uiThread, repository)
    }

    fun provideSearchStudentUseCase(): SearchStudentsUseCase {
        return SearchStudentsUseCase(uiThread, repository)
    }

    fun provideGetStudentByIdUseCase(): GetStudentByIdUseCase {
        return GetStudentByIdUseCase(uiThread, repository)
    }

    fun provideUpdateStudentUseCase(): UpdateStudentUseCase {
        return UpdateStudentUseCase(uiThread, repository)
    }

    fun provideDeleteStudentUseCase(): DeleteStudentUseCase {
        return DeleteStudentUseCase(uiThread, repository)
    }
}