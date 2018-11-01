package com.gmail.pmanenok.data.entity

import com.gmail.pmanenok.domain.entity.student.Student

fun StudentResponse.transformToDomain(): Student {
    return Student(id = id, name = name, age = age)
}

