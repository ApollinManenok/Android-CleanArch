package com.gmail.pmanenok.data.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "student")
data class StudentDb(
    @PrimaryKey
    val id: String,
    val name: String,
    val age: String,
    val gender: String,
    val imageUrl: String
)