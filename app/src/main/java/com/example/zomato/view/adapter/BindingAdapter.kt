package com.example.zomato.view.adapter

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

object BindingAdapter {
    @BindingAdapter("app:setImage")
    @JvmStatic
    fun setImage(view: ImageView, imageUrl: String) {
        if (imageUrl.isEmpty()) {

        } else {
            Glide.with(view.context).load(imageUrl).into(view)
        }
    }
}