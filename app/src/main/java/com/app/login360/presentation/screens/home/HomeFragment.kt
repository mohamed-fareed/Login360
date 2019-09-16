package com.app.login360.presentation.screens.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.app.login360.R
import com.app.login360.presentation.gone
import com.app.login360.presentation.openLogin
import com.app.login360.presentation.showToast
import com.app.login360.presentation.visible
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loading.observe(this, Observer {
            progressbar.apply { if (it) visible() else gone() }
        })

        viewModel.userData.observe(this, Observer {
            group_details.visible()

            val nameText = "${getString(R.string.label_name)}: ${it.name}"
            tv_name.text = nameText

            val emailText = "${getString(R.string.label_email)}: ${it.email}"
            tv_name.text = emailText

            val phoneText = "${getString(R.string.label_phone)}: ${it.phone}"
            tv_name.text = phoneText
        })

        viewModel.userLoggedOut.observe(this, Observer {
            showToast(R.string.label_logout_success)
            openLogin()
            requireActivity().finish()
        })

        btn_logout.setOnClickListener { viewModel.logout() }
    }
}
