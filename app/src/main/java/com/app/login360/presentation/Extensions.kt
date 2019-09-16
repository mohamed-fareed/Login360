package com.app.login360.presentation

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout

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

fun String.isValidPassword() = matches(
    Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{8,}\$")
)

fun String.isValidEmail() = matches(Regex("^(.+)@(.+)\$"))

fun TextInputLayout.removeError() {
    error = null
    isErrorEnabled = false
}