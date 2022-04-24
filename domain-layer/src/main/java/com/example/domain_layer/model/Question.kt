package com.example.domain_layer.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Question(

    @field:SerializedName("id")
    val _id: Int? = null,

    @field:SerializedName("question")
    val _question: String? = null,

    @field:SerializedName("answers")
    val _answers: List<String>? = null,

    @field:SerializedName("selectedAnswer")
    var _selectedAnswer: Int = -1

) : Parcelable