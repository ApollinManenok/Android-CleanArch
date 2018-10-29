package com.gmail.pmanenok.domain.entity.user

import com.gmail.pmanenok.domain.entity.DomainEntity

data class UserData(
    val id: String = "", val fio: String = "", val imageUrl: String = "",
    val age: String = "", val gender: String = ""
) : DomainEntity