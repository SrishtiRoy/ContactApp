package com.sri.contactdemo.bindingAdapter

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sri.contactdemo.R

@BindingAdapter("profilePictureUrl")
fun bindProfilePicture(imageView: ImageView, profilePictureUrl: String?) {

    profilePictureUrl?.let {
        val profilePictureUri = profilePictureUrl.toUri()

        Glide.with(imageView.context)
            .load(profilePictureUri)
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_loading_profile_picture)
            .apply(RequestOptions.circleCropTransform())
            .into(imageView)
    }
}
