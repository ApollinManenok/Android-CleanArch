package com.gmail.pmanenok.domain.usecases

import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.domain.executor.PostExecutorThread
import com.gmail.pmanenok.domain.repositories.StudentRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetStudentsUseCase @Inject constructor(
    postExecutorThread: PostExecutorThread,
    val studentRepository: StudentRepository
) :    BaseUseCase(postExecutorThread) {

    /*@Inject constructor(
        postExecutorThread: PostExecutorThread,
        studentRepository: StudentRepository
    ) : this(studentRepository) {
        this.postExecutorThread = postExecutorThread.getScheduler()
    }*/

    fun get(): Observable<List<Student>> {
        return studentRepository.get()
            .observeOn(postExecutorThread)
            .subscribeOn(workExecutorThread)
    }
}