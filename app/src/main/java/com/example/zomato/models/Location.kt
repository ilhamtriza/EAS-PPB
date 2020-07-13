package com.example.zomato.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    @SerializedName("address")
    @Expose
    val address: String,
    @SerializedName("locality")
    @Expose
    val locality: String,
    @SerializedName("city")
    @Expose
    val city: String,
    @SerializedName("zipcode")
    @Expose
    val zipcode: String
) : Parcelable