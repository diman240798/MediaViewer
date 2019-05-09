package com.nanicky.mediaviewer.util

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:srcBitmap")
fun bitmapBinder(imageView: ImageView, bitmap: Bitmap) {
    imageView.setImageBitmap(bitmap);
}