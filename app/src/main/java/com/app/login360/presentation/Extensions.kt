package com.app.login360.presentation

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun View.visible() {
    visibility = VISIBLE
}

fun View.gone() {
    visibility = GONE
}

fun Fragment.showToast(@StringRes message: Int) =
    Toast.makeText(requireContext(), getString(message), Toast.LENGTH_LONG).show()

fun Fragment.showToast(message: String) =
    Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()