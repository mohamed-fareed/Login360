package com.app.login360.presentation.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.app.login360.R
import com.app.login360.presentation.gone
import com.app.login360.presentation.removeError
import com.app.login360.presentation.showToast
import com.app.login360.presentation.visible
import kotlinx.android.synthetic.main.login_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loading.observe(this, Observer {
            progressbar.apply { if (it) visible() else gone() }
        })

        viewModel.loginFailed.observe(this, Observer {
            showToast(R.string.error_generic)
        })

        viewModel.loginSuccess.observe(this, Observer { name ->
            showToast("${getString(R.string.label_welcome_back)}, $name")
        })

        viewModel.invalidEmail.observe(this, Observer {
            layout_email.error = getString(R.string.invalid_email)
        })

        viewModel.invalidPassword.observe(this, Observer {
            layout_password.error = getString(R.string.invalid_password)
        })

        btn_login.setOnClickListener {
            layout_email.removeError()
            layout_password.removeError()

            viewModel.login(
                et_email.text.toString().trim(),
                et_password.text.toString().trim()
            )
        }
    }
}
