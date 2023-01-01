package com.areeb.pokedeex.utils

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.areeb.pokedeex.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun setImageView(imageView: ImageView, imageUrl: String?) {
    imageView.let {
        val imageUri = imageUrl?.toUri()?.buildUpon()?.scheme("https")?.build()
        Glide.with(imageView.context)
            .load(imageUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_pokeball)
                    .error(R.drawable.ic_loading_error)
            )
            .into(imageView)
    }
}
