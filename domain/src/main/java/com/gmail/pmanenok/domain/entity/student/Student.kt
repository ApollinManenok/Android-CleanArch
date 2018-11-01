package com.gmail.pmanenok.domain.entity.student

import com.gmail.pmanenok.domain.entity.DomainEntity

data class Student(
    val id: String,
    val name: String,
    val age: Int,
    val gender: String = "female",
    val imageUrl: String = ""
) : DomainEntity