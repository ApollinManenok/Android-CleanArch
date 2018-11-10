package com.gmail.pmanenok.data.repositories

import android.util.Log
import com.gmail.pmanenok.data.db.dao.StudentDao
import com.gmail.pmanenok.data.db.entity.transformToDb
import com.gmail.pmanenok.data.db.entity.transformToDomain
import com.gmail.pmanenok.data.entity.transformToDomain
import com.gmail.pmanenok.data.entity.transformToRequest
import com.gmail.pmanenok.data.net.RestService
import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.domain.entity.student.StudentSearch
import com.gmail.pmanenok.domain.repositories.StudentRepository
import io.reactivex.Completable
import io.reactivex.Observable

class StudentRepositoryImplTestDb(val apiService: RestService, val studentDao: StudentDao) : StudentRepository {

    companion object {
        const val TIME_BUFFER = 60000
    }

    private var lastTimeUpdate = 0L

    override fun get(id: String): Observable<Student> {
        return studentDao.getById(id).toObservable().map { it.transformToDomain() }
    }

    override fun get(): Observable<List<Student>> {
        Log.e("aaa", "StudentRepositoryImplTestDb get")
        return studentDao.getAll().toObservable()
            .flatMap { studentDbList ->
                if (studentDbList.isEmpty() || System.currentTimeMillis() - lastTimeUpdate > TIME_BUFFER) {
                    Log.e(
                        "aaa",
                        "StudentRepositoryImplTestDb getAll db empty ${studentDbList.isEmpty()} || update ${System.currentTimeMillis() - lastTimeUpdate > TIME_BUFFER}"
                    )
                    apiService.getStudents()
                        .doOnNext {
                            lastTimeUpdate = System.currentTimeMillis()
                            studentDao.deleteAll()
                            studentDao.insert(it.map { it.transformToDb() })
                        }
                        .map { it.map { it.transformToDomain() } }
                        .onErrorReturn {
                            if (studentDbList.isEmpty()) {
                                throw it
                            } else {
                                Log.e("aaa", "StudentRepositoryImplTestDb connection error")
                                studentDbList.map { student -> student.transformToDomain() }
                            }
                        }
                } else {
                    Log.e("aaa", "StudentRepositoryImplTestDb getAll db not empty nor update")
                    Observable.just(studentDbList).map { list -> list.map { student -> student.transformToDomain() } }
                }
            }
    }


    override fun search(search: StudentSearch): Observable<List<Student>> {
        //TODO change search method!!!
        Log.e("aaa", "StudentRepositoryImplTestDb search")
        return get()
    }

    override fun update(student: Student): Completable {
        return Completable.fromObservable(apiService.updateStudent(student.transformToRequest()).doFinally {
            studentDao.update(student.transformToDb())
        })
    }

    override fun save(student: Student): Completable {
        return Completable.fromObservable(apiService.saveStudent(student.transformToRequest()).doFinally {
            studentDao.insert(student.transformToDb())
        })
    }

    override fun delete(studentId: String): Completable {
        return Completable.fromObservable(apiService.deleteStudent(studentId).doFinally {
            studentDao.deleteById(studentId)
        })
    }
}