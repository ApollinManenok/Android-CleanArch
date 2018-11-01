package com.gmail.pmanenok.domain.usecases

import com.gmail.pmanenok.domain.executor.PostExecutorThread
import com.gmail.pmanenok.domain.repositories.StudentRepository
import io.reactivex.Completable

class DeleteStudentUseCase(postExecutorThread: PostExecutorThread, private val studentRepository: StudentRepository) :
    BaseUseCase(postExecutorThread) {

    fun delete(studentId: String): Completable {
        return studentRepository.delete(studentId)
            .observeOn(postExecutorThread)
            .subscribeOn(workExecutorThread)
    }
}