package com.example.zomato.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rating(
    @SerializedName("aggregate_rating")
    @Expose
    val rating: String,
    @SerializedName("rating_text")
    @Expose
    val rating_text: String,
    @SerializedName("votes")
    @Expose
    val votes: String
) : Parcelable