package com.example.zomato.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Categories(
    @SerializedName("id")
    @Expose
    val category_id: Int,
    @SerializedName("name")
    @Expose
    val category_name: String
) : Parcelable