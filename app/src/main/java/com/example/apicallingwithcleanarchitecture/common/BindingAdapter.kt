package com.example.apicallingwithcleanarchitecture.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.apicallingwithcleanarchitecture.R


@BindingAdapter("urlToImage")
fun urlToImage(view: ImageView, s: String?) {
    val options = RequestOptions.placeholderOf(R.drawable.ic_launcher_foreground).error(R.drawable.ic_launcher_foreground)
    Glide.with(view).setDefaultRequestOptions(options).load(s ?: "").into(view)
}