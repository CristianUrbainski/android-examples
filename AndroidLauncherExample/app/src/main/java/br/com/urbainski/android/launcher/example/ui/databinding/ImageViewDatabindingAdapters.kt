package br.com.urbainski.android.launcher.example.ui.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object ImageViewDatabindingAdapters {

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }

}