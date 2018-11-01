package com.gmail.pmanenok.data.net

import com.gmail.pmanenok.data.entity.StudentDeleteRequest
import com.gmail.pmanenok.data.entity.StudentRequest
import com.gmail.pmanenok.data.entity.StudentResponse
import io.reactivex.Observable
import retrofit2.http.*

interface RestApi {

    //https://tut.by/
    @GET("students")
    fun getStudents(): Observable<List<StudentResponse>>

    //https://tut.by/students?id=afgj
    //@GET("student")
    //fun getStudents(@Query("id") id: String): Observable<StudentResponse>

    //https://tut.by/students/1245s/
    @GET("students")
    fun getStudentById(@Path("id") id: String): Observable<StudentResponse>

    //https://tut.by/students/
    @POST("students")
    //@FormUrlEncoded
    fun updateStudent(@Body student: StudentRequest): Observable<StudentResponse>

    //https://tut.by/students/243s/
    @POST("students/{id}/")
    fun updateStudent(@Path("id") id: String, @Body student: StudentRequest): Observable<StudentResponse>


    //https://tut.by/students
    @DELETE("students")
    //@Header("key: value")
    fun deleteStudent(@Body student: StudentDeleteRequest): Observable<Void>

    //https://tut.by/students/345g/
    @DELETE("students/{id}/")
    fun deleteStudent(@Path("id") id: String): Observable<Void>


}