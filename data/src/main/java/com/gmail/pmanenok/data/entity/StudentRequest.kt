package com.gmail.pmanenok.data.entity

import com.google.gson.annotations.SerializedName

data class StudentRequest(
    @SerializedName("objectId")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("age")
    val age: Int,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("imageUrl")
    val imageUrl: String
) : DataEntity