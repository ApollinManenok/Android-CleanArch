package com.gmail.pmanenok.data.net

import com.gmail.pmanenok.data.entity.StudentRequest
import com.gmail.pmanenok.data.entity.StudentResponse
import io.reactivex.Observable
import retrofit2.http.*

interface RestApi {
    @GET("students")
    fun getStudents(@Query("pageSize") size: Int): Observable<List<StudentResponse>>

    //https://tut.by/students?id=afgj
    //@GET("student")
    //fun getStudents(@Query("id") id: String): Observable<StudentResponse>

    //https://tut.by/students/1245s/
    @GET("students/{id}")
    fun getStudentById(@Path("id") id: String): Observable<StudentResponse>

    //https://tut.by/students/
    @POST("students")
    //@FormUrlEncoded
    fun saveStudent(@Body student: StudentRequest): Observable<StudentResponse>

    //https://tut.by/students/243s/
    @PUT("students")
    fun updateStudent(@Body student: StudentRequest): Observable<StudentResponse>


    //https://tut.by/students
    //@DELETE("students")
    //@Header("key: value")
    //fun deleteStudent(@Body student: StudentDeleteRequest): Observable<Void>

    //https://tut.by/students/345g/
    @DELETE("students/{id}")
    fun deleteStudent(@Path("id") id: String): Observable<String>
}