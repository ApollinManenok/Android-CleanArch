package com.gmail.pmanenok.domain.executor


import io.reactivex.Scheduler

class PostExecutorThreadTest(private val testScheduler: Scheduler) : PostExecutorThread {

    override fun getScheduler(): Scheduler {
        return testScheduler
    }
}