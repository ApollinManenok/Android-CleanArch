package com.gmail.pmanenok.domain.usecases

import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.domain.executor.PostExecutorThread
import com.gmail.pmanenok.domain.repositories.StudentRepository
import io.reactivex.Completable

class UpdateStudentUseCase(postExecutorThread: PostExecutorThread, private val studentRepository: StudentRepository) :
    BaseUseCase(postExecutorThread) {
    fun update(student: Student): Completable {
        return studentRepository.update(student)
            .observeOn(postExecutorThread)
            .subscribeOn(workExecutorThread)
    }

    fun save(student: Student): Completable {
        return studentRepository.save(student)
            .observeOn(postExecutorThread)
            .subscribeOn(workExecutorThread)
    }
}