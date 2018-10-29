package com.gmail.pmanenok.data.repositories

import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.domain.entity.student.StudentSearch
import com.gmail.pmanenok.domain.repositories.StudentRepository
import io.reactivex.Completable
import io.reactivex.Observable

class StudentRepositoryImpl : StudentRepository {
    private var list = listOf<Student>(
        Student(
            "0", "Jane", 10, "female",
            imageUrl = "https://petapixel.com/assets/uploads/2018/07/dogphotosfeat-800x420.jpg"
        ),
        Student("1", "John", 34, imageUrl = "https://www.bensound.com/bensound-img/november.jpg"),
        Student("2", "Peter", 87),
        Student(
            "3", "Jack", 32,
            imageUrl = "https://images.pexels.com/photos/46710/pexels-photo-46710.jpeg?auto=compress&cs=tinysrgb&h=350"
        ),
        Student(
            "4", "Sue", 89, "female",
            imageUrl = "https://i.pinimg.com/originals/00/f9/12/00f9120dabc6cacccf5a4eb14fe10f3c.jpg"
        ),
        Student("5", "Kate", 23, "female")
    )

    override fun get(id: String): Observable<Student> {
        for (item in list) {
            if (item.id == id)
                return Observable.just(item)
        }
        return Observable.just(list[0])
    }

    override fun get(): Observable<List<Student>> {
        return Observable.just(list)
    }

    override fun search(search: StudentSearch): Observable<List<Student>> {
        val searchList = mutableListOf<Student>()
        searchList.add(list[3])
        searchList.add(list[4])
        return Observable.just(list)
    }

    override fun update(student: Student): Completable {
        return Completable.complete()
    }

    override fun delete(studentId: String): Completable {
        return Completable.complete()
    }
}