package com.gmail.pmanenok.domain.repositories

import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.domain.entity.student.StudentSearch
import io.reactivex.Completable
import io.reactivex.Observable

interface StudentRepository : BaseRepository {

    fun get(): Observable<List<Student>>
    fun get(id: String): Observable<Student>
    fun search(search: StudentSearch): Observable<List<Student>>
    fun update(student: Student): Completable
    fun save(student: Student): Completable
    fun delete(studentId: String): Completable
}