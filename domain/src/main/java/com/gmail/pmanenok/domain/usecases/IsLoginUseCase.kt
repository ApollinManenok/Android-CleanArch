package com.gmail.pmanenok.domain.usecases

import com.gmail.pmanenok.domain.repositories.AuthRepository
import io.reactivex.Single

class IsLoginUseCase(val authRepository: AuthRepository) :
    BaseUseCase() {
    fun isLogin(): Single<Boolean> {
        return Single.just(authRepository.isLogin())
    }
}