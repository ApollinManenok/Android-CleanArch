package com.gmail.pmanenok.domain.usecases

import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.domain.repositories.StudentRepository
import io.reactivex.Observable

class GetStudentsUseCase(val studentRepository: StudentRepository) : BaseUseCase() {
    fun get(): Observable<List<Student>> {
        return studentRepository.get()
    }
}