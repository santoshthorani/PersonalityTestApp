package com.example.presentation_layer.utils

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.text.SimpleDateFormat
import java.util.*


fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer {
        it?.let { t ->
            action(t)
        }
    })
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun String.isValidEmail(): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun Context.dpToPx(dp: Float): Float {
    return (dp * resources.displayMetrics.density).toFloat()
}

fun Context.pxToDp(px: Float): Float {
    return (px / resources.displayMetrics.density).toFloat()
}

fun Fragment.getDate(): String {
    val c: Date = Calendar.getInstance().time
    val df = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return df.format(c).toString()
}
