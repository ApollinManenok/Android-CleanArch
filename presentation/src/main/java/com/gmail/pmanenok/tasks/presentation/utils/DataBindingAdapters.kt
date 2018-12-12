package com.gmail.pmanenok.tasks.presentation.utils

import android.databinding.BindingAdapter
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.gmail.pmanenok.tasks.R
import com.squareup.picasso.Picasso
import io.reactivex.subjects.PublishSubject

@BindingAdapter("src")
fun setSrc(view: ImageView, url: String?) {
    if (url.isNullOrBlank()) {
        Picasso.get().load(R.drawable.default_user).into(view)
    } else {
        Log.e("aaa", url)
        Picasso.get().load(url).transform(PicassoCircleTransformation()).into(view)
    }
}

@BindingAdapter("onClick")
fun View.onClick(subject:PublishSubject<Boolean>){
    setOnClickListener{
        subject.onNext(true)
    }
}



@BindingAdapter("visibility")
fun View.visidility(visibility: Boolean) {
    this.visibility = if (visibility) View.VISIBLE else View.GONE
}

