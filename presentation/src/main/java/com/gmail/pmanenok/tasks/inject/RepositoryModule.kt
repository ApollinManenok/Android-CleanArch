package com.gmail.pmanenok.tasks.inject

import com.gmail.pmanenok.data.db.AppDataBase
import com.gmail.pmanenok.data.db.dao.StudentDao
import com.gmail.pmanenok.data.net.RestService
import com.gmail.pmanenok.data.repositories.StudentRepositoryImplTestDb
import com.gmail.pmanenok.domain.repositories.StudentRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideStudentRepository(repository: StudentRepositoryImplTestDb): StudentRepository

}