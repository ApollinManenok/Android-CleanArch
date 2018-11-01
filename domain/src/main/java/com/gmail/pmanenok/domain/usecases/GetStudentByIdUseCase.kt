package com.gmail.pmanenok.domain.usecases

import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.domain.executor.PostExecutorThread
import com.gmail.pmanenok.domain.repositories.StudentRepository
import io.reactivex.Observable

class GetStudentByIdUseCase(postExecutorThread: PostExecutorThread, val studentRepository: StudentRepository) :
    BaseUseCase(postExecutorThread) {
    fun get(studentId: String): Observable<Student> {
        return studentRepository.get(studentId)
            .observeOn(postExecutorThread)
            .subscribeOn(workExecutorThread)
    }
}