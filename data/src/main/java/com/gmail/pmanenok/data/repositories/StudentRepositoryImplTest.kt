package com.gmail.pmanenok.data.repositories

import com.gmail.pmanenok.data.entity.transformToDomain
import com.gmail.pmanenok.data.entity.transformToRequest
import com.gmail.pmanenok.data.net.RestService
import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.domain.entity.student.StudentSearch
import com.gmail.pmanenok.domain.repositories.StudentRepository
import io.reactivex.Completable
import io.reactivex.Observable

class StudentRepositoryImplTest(val apiService: RestService) : StudentRepository {
    //https://api.backendless.com/3C38FF89-D6CA-F09A-FF2D-375419F6C600/6D5A1710-032A-8000-FF13-60CA35177F00/data/students
    override fun get(id: String): Observable<Student> {
        return apiService.getStudentById(id).map { it.transformToDomain() }
    }

    override fun get(): Observable<List<Student>> {
        return apiService.getStudents().map { it.map { it.transformToDomain() } }
    }

    override fun search(search: StudentSearch): Observable<List<Student>> {
        //TODO change search method!!!
        return apiService.getStudents().map { it.map { it.transformToDomain() } }
    }

    override fun update(student: Student): Completable {
        return Completable.fromObservable(apiService.updateStudent(student.transformToRequest()))
    }

    override fun save(student: Student): Completable {
        return Completable.fromObservable(apiService.saveStudent(student.transformToRequest()))
    }

    override fun delete(studentId: String): Completable {
        return Completable.fromObservable(apiService.deleteStudent(studentId))
    }
}
