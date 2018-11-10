package com.gmail.pmanenok.tasks.factories

import android.util.Log
import com.gmail.pmanenok.data.db.AppDataBase
import com.gmail.pmanenok.data.net.RestService
import com.gmail.pmanenok.data.repositories.StudentRepositoryImpl
import com.gmail.pmanenok.data.repositories.StudentRepositoryImplTestDb
import com.gmail.pmanenok.domain.usecases.*
import com.gmail.pmanenok.tasks.app.App
import com.gmail.pmanenok.tasks.executor.UIThread

object UseCaseProvider {
    val uiThread = UIThread()
    val restService =
        RestService("https://api.backendless.com/3C38FF89-D6CA-F09A-FF2D-375419F6C600/6D5A1710-032A-8000-FF13-60CA35177F00/data/")
    val studentDao = AppDataBase.getInstance(App.instance.applicationContext).getStudentDao()

    //val repository = StudentRepositoryImplTest(restService)
    val repository = StudentRepositoryImplTestDb(restService, studentDao)
    val repositoryGet = StudentRepositoryImpl()

    fun provideGetStudentListUseCase(): GetStudentsUseCase {
        Log.e("aaa", "UseCaseProvider provideGetStudentListUseCase")
        return GetStudentsUseCase(uiThread, repository)
    }

    fun provideSearchStudentUseCase(): SearchStudentsUseCase {
        Log.e("aaa", "UseCaseProvider provideSearchStudentUseCase")
        return SearchStudentsUseCase(uiThread, repository)
    }

    fun provideGetStudentByIdUseCase(): GetStudentByIdUseCase {
        Log.e("aaa", "UseCaseProvider provideGetStudentByIdUseCase")
        return GetStudentByIdUseCase(uiThread, repository)
    }

    fun provideUpdateStudentUseCase(): UpdateStudentUseCase {
        Log.e("aaa", "UseCaseProvider provideUpdateStudentUseCase")
        return UpdateStudentUseCase(uiThread, repository)
    }

    fun provideDeleteStudentUseCase(): DeleteStudentUseCase {
        Log.e("aaa", "UseCaseProvider provideDeleteStudentUseCase")
        return DeleteStudentUseCase(uiThread, repository)
    }
}