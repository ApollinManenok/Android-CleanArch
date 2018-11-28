package com.gmail.pmanenok.data.db.dao

import android.arch.persistence.room.*
import com.gmail.pmanenok.data.db.entity.StudentDb
import io.reactivex.Completable
import io.reactivex.Flowable


@Dao
interface StudentDao {
    @Insert
    fun insert(students: List<StudentDb>) // (vararg student: StudentDb)(Student...student)

    @Update
    fun update(student: StudentDb)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(student: StudentDb)

    @Delete
    fun delete(student: StudentDb)

    @Query("DELETE FROM student WHERE id = :id")
    fun deleteById(id: String)

    @Query("DELETE FROM student")
    fun deleteAll()

    @Query("SELECT * FROM student")
    fun getAll(): Flowable<List<StudentDb>>

    @Query("SELECT * FROM student WHERE id = :id LIMIT 1")
    fun getById(id: String): Flowable<StudentDb>
}