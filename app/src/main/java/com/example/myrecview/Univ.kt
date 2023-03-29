package com.example.myrecview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Univ(
    val name: String,
    val description: String,
    val photo: Int,
    val ukt: String,
    val alamat: String
) : Parcelable
