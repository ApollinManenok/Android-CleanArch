package com.gmail.pmanenok.data.repositories

import com.gmail.pmanenok.data.entity.transformToLoginRequest
import com.gmail.pmanenok.data.net.RestService
import com.gmail.pmanenok.data.sharedprefs.AppSharedPrefs
import com.gmail.pmanenok.domain.entity.Login
import com.gmail.pmanenok.domain.repositories.AuthRepository
import io.reactivex.Completable

class AuthRepositoryImpl(private val sharedPrefs: AppSharedPrefs, private val apiService: RestService) : AuthRepository {
    override fun login(login: Login): Completable {
        return Completable.fromObservable(apiService
            .login(login.transformToLoginRequest())
            .doOnNext {
                sharedPrefs.putToken(it.token)
            })
    }

    override fun isLogin(): Boolean {
        return sharedPrefs.getToken().isNotEmpty()
    }

}