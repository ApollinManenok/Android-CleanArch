package com.gmail.pmanenok.tasks.presentation.utils

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.gmail.pmanenok.tasks.R
import com.gmail.pmanenok.tasks.app.PicassoCircleTransformation
import com.squareup.picasso.Picasso

@BindingAdapter("src")
fun setSrc(view: ImageView, url: String?) {
    if (url == "") {
        Picasso.get().load(R.drawable.default_user).into(view)
    } else {
        Picasso.get().load(url).transform(PicassoCircleTransformation()).into(view)
    }
}

@BindingAdapter("visibility")
fun View.visidility(visibility: Boolean) {
    this.visibility = if (visibility) View.VISIBLE else View.GONE
}