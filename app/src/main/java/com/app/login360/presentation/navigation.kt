package com.app.login360.presentation

import android.content.Intent
import androidx.fragment.app.Fragment
import com.app.login360.presentation.screens.home.HomeActivity
import com.app.login360.presentation.screens.login.LoginActivity

fun Fragment.openHome() {
    startActivity(Intent(requireContext(), HomeActivity::class.java))
}

fun Fragment.openLogin() {
    startActivity(Intent(requireContext(), LoginActivity::class.java))
}