package com.gmail.pmanenok.domain.usecases

import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.domain.repositories.StudentRepository
import io.reactivex.Completable

class UpdateStudentUseCase(private val studentRepository: StudentRepository) : BaseUseCase() {
    fun update(student: Student): Completable {
        return studentRepository.update(student)
    }
}