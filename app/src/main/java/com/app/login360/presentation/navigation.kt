package com.app.login360.presentation

import android.content.Intent
import androidx.fragment.app.Fragment
import com.app.login360.presentation.screens.home.HomeActivity

fun Fragment.openHome() {
    startActivity(Intent(requireContext(), HomeActivity::class.java))
}