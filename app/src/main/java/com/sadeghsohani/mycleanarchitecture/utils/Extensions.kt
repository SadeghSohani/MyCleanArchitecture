package com.sadeghsohani.mycleanarchitecture.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sadeghsohani.mycleanarchitecture.R
import com.sadeghsohani.mycleanarchitecture.di.CleanComponent
import com.sadeghsohani.mycleanarchitecture.di.CleanComponentProvider
import kotlinx.android.synthetic.main.colored_toast_layout.view.*

fun Context?.toast(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

@Suppress("DEPRECATION")
@SuppressLint("InflateParams")
fun Context.coloredToast(msg: String) {
    val toast = Toast(this)
    val view = LayoutInflater.from(this).
    inflate(R.layout.colored_toast_layout, null, false)
    view.toast_msg.text = msg

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        view.setBackgroundColor(resources.getColor(R.color.colorToast,(this as Activity).theme))
    }else {
        view.setBackgroundColor(resources.getColor(R.color.colorToast))
    }

    toast.view = view
    toast.duration = Toast.LENGTH_SHORT
    toast.show()
}

//component extensions
fun Context.findCleanComponent(): CleanComponent =
    (applicationContext as? CleanComponentProvider)
        ?.provideAppComponent()
        ?: throw IllegalStateException("application class must implement AppComponentProvider")

fun View.findCleanComponent(): CleanComponent =
    context.findCleanComponent()

fun Fragment.findCleanComponent(): CleanComponent =
    requireContext().findCleanComponent()