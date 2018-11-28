package com.gmail.pmanenok.data.net

import com.gmail.pmanenok.domain.entity.AppErrorType
import com.gmail.pmanenok.domain.entity.AppException
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RestServiceTest {

    @Test
    fun testServerError() {
        val server = MockWebServer()



        val response = MockResponse()
        response.setResponseCode(400)
        response.setBody("{\"message\" : \"Error text\", \"errorCode\" : 123}")
        server.enqueue(response)
        server.start()

        val url = server.url("/")
        val restService = RestService(url.toString())
        restService
            .getStudents()
            .test()
            .assertError {
                if (it is AppException && it.errorType == AppErrorType.BLOCKED) true
                else false
            }
    }
}