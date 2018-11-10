package com.gmail.pmanenok.data.net

import android.util.Log
import com.gmail.pmanenok.data.entity.StudentRequest
import com.gmail.pmanenok.data.entity.StudentResponse
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestService(private val apiUrl: String) {
    private val restApi: RestApi

    init {
        val okHttpBuilder = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
        okHttpBuilder
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

        //val gson = Gson()
        val gson = GsonBuilder()
            //.registerTypeAdapter(StudentResponse::class.java, )
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(apiUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpBuilder.build())
            .build()

        restApi = retrofit.create(RestApi::class.java)
    }

    fun getStudents(): Observable<List<StudentResponse>> {
        Log.e("aaa", "RestService getStudents")
        return restApi.getStudents(30)
    }

    fun getStudentById(id: String): Observable<StudentResponse> {
        Log.e("aaa", "RestService getStudentById")
        return restApi.getStudentById(id)
    }

    fun updateStudent(student: StudentRequest): Observable<StudentResponse> {
        Log.e("aaa", "RestService updateStudent")
        return restApi.updateStudent(student)
    }

    fun saveStudent(student: StudentRequest): Observable<StudentResponse> {
        Log.e("aaa", "RestService saveStudent")
        return restApi.saveStudent(student)
    }

    fun deleteStudent(id: String): Observable<String> {
        Log.e("aaa", "RestService deleteStudent $id")
        return restApi.deleteStudent(id)
    }
}
//get all
//get one by id

//search by name
//search by age

//add student

//update student

//delete one
//delete all