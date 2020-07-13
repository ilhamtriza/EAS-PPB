package com.example.zomato.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restaurant(
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("id")
    @Expose
    val res_id: String,
    @SerializedName("url")
    @Expose
    val url: String,
    @SerializedName("cuisines")
    @Expose
    val cuisines: String,
    @SerializedName("thumb")
    @Expose
    val thumbnail: String,
    @SerializedName("menu_url")
    @Expose
    val menu: String,
    @SerializedName("location")
    @Expose
    val location: Location,
    @SerializedName("user_rating")
    @Expose
    val rating: Rating
) : Parcelable