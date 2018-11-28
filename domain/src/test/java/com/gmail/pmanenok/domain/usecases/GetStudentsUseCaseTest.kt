package com.gmail.pmanenok.domain.usecases

import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.domain.executor.PostExecutorThreadTest
import com.gmail.pmanenok.domain.repositories.StudentRepository
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetStudentsUseCaseTest {

    @Mock
    private lateinit var repository: StudentRepository

    private lateinit var testScheduler: TestScheduler

    private lateinit var useCase: GetStudentsUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this);
        testScheduler = TestScheduler();
        useCase = GetStudentsUseCase(PostExecutorThreadTest(testScheduler), repository)
        useCase.workExecutorThread = testScheduler
    }

    @Test
    fun test() {
        val studentList = listOf(
            Student("1", "Student1", 25),
            Student("2", "Student2", 25),
            Student("3", "Student3", 25)
        )
        `when`(repository.get()).thenReturn(Observable.just(studentList))

        val observer = TestObserver<List<Student>>();
        useCase
            .get()
            .subscribe(observer)

        testScheduler.triggerActions()

        observer.assertNoErrors()
            .assertValues(studentList)
            .assertValue {
                it.size == 3
            }

        observer.dispose()
    }
}