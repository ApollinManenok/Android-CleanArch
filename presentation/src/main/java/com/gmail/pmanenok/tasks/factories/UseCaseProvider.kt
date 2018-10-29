package com.gmail.pmanenok.tasks.factories

import com.gmail.pmanenok.data.repositories.StudentRepositoryImpl
import com.gmail.pmanenok.domain.usecases.GetStudentsUseCase
import com.gmail.pmanenok.domain.usecases.SearchStudentsUseCase

object UseCaseProvider {
    fun provideGetStudentListUseCase():GetStudentsUseCase{
        return GetStudentsUseCase(StudentRepositoryImpl())
    }

    fun provideSearchStudentUseCase(): SearchStudentsUseCase {
        return SearchStudentsUseCase(StudentRepositoryImpl())
    }
}