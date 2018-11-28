package com.gmail.pmanenok.domain.entity

data class AppException(val errorType: AppErrorType) : Exception(),DomainEntity{
}