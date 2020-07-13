package com.example.zomato.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("categories")
    @Expose
    private var categories: Categories? = null
)