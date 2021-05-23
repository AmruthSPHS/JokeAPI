package com.example.jokeapi.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyJoke(
    val id: Int,
    val punchline: String,
    val setup: String,
    val type: String
) : Parcelable