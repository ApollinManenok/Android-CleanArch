package com.gmail.pmanenok.data.repositories

import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.domain.entity.student.StudentSearch
import com.gmail.pmanenok.domain.repositories.StudentRepository
import io.reactivex.Completable
import io.reactivex.Observable

class StudentRepositoryImpl : StudentRepository {
    private var list = mutableListOf<Student>(
        Student(
            "E236E066-3F84-93F9-FFDB-721132CED100", "Jane", 10,
            imageUrl = "https://petapixel.com/assets/uploads/2018/07/dogphotosfeat-800x420.jpg"
        ),
        Student("1", "John", 34, "male", "https://www.bensound.com/bensound-img/november.jpg"),
        Student(
            "2", "Sue", 89,
            imageUrl = "https://i.pinimg.com/originals/00/f9/12/00f9120dabc6cacccf5a4eb14fe10f3c.jpg"
        ),
        Student(
            "3", "Jack", 32, "male",
            "https://images.pexels.com/photos/46710/pexels-photo-46710.jpeg?auto=compress&cs=tinysrgb&h=350"
        ),
        Student("4", "Peter", 87, "male"),
        Student("5", "Kate", 23)
    )

    override fun get(id: String): Observable<Student> {
        return Observable.just(searchById(id))
    }

    private fun searchById(id: String): Student? {
        for (item in list) {
            if (item.id == id)
                return item
        }
        return null
    }

    private fun getPositionById(id: String): Int? {
        var position = 0
        if (id == "") {
            return -1
        }
        for (item in list) {
            if (item.id == id)
                return position
            position++
        }
        return null
    }

    override fun get(): Observable<List<Student>> {
        return Observable.just(list)
    }

    override fun search(search: StudentSearch): Observable<List<Student>> {
        val searchList = mutableListOf<Student>()
        if (search.name != "") {
            searchList.add(list[3])
        } else if (search.age != 0) {
            searchList.add(list[0])
            searchList.add(list[4])
        } else {
            searchList.addAll(list)
        }
        return Observable.just(searchList)
    }

    override fun update(student: Student): Completable {
        val position = getPositionById(student.id)
        if (position == -1) {
            if (list.add(student)) return Completable.complete()
        } else if (position != null) {
            list[position] = student
            return Completable.complete()
        }
        return Completable.never()
    }

    override fun save(student: Student): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(studentId: String): Completable {
        if (list.remove(searchById(studentId))) {
            return Completable.complete()
        }
        return Completable.never()
    }
}