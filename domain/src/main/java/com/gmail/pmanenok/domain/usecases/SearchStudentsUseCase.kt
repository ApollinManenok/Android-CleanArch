package com.gmail.pmanenok.domain.usecases

import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.domain.entity.student.StudentSearch
import com.gmail.pmanenok.domain.executor.PostExecutorThread
import com.gmail.pmanenok.domain.repositories.StudentRepository
import io.reactivex.Observable

class SearchStudentsUseCase(postExecutorThread: PostExecutorThread, private val studentRepository: StudentRepository) :
    BaseUseCase(postExecutorThread) {
    fun search(search: StudentSearch): Observable<List<Student>> {
        return studentRepository.search(search)
            .observeOn(postExecutorThread)
            .subscribeOn(workExecutorThread)
    }
}