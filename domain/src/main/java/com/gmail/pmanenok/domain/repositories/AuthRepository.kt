package com.gmail.pmanenok.domain.repositories

import com.gmail.pmanenok.domain.entity.Login
import io.reactivex.Completable
import io.reactivex.Observable


interface AuthRepository :BaseRepository{
    fun login(login: Login): Completable

    fun isLogin():Boolean
//    fun getToken(): Observable<Token>
}