package com.app.login360.presentation.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.login360.domain.usecases.GetLoggedInUseCase
import com.app.login360.domain.usecases.LoginUseCase
import com.app.login360.presentation.isValidEmail
import com.app.login360.presentation.isValidPassword
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val getLoggedInUseCase: GetLoggedInUseCase
) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _loginSuccess = MutableLiveData<String>()
    val loginSuccess: LiveData<String> = _loginSuccess

    private val _loginFailed = MutableLiveData<Throwable>()
    val loginFailed: LiveData<Throwable> = _loginFailed

    private val _invalidEmail = MutableLiveData<Unit>()
    val invalidEmail: LiveData<Unit> = _invalidEmail

    private val _invalidPassword = MutableLiveData<Unit>()
    val invalidPassword: LiveData<Unit> = _invalidPassword

    private val _userLoggedIn = MutableLiveData<Unit>()
    val userLoggedIn: LiveData<Unit> = _userLoggedIn

    private val compositeDisposable = CompositeDisposable()

    init {
        checkUserLoginState()
    }

    private fun checkUserLoginState() {
        compositeDisposable.add(
            getLoggedInUseCase.execute(Unit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it != null)
                        _userLoggedIn.postValue(Unit)
                }, {
                    _loginFailed.postValue(it)
                })
        )
    }

    fun login(email: String, password: String) {
        if (!isFormValid(email, password)) return
        if (_loading.value == true) return // don't make request while other is loading

        _loading.postValue(true)

        compositeDisposable.add(
            loginUseCase.execute(
                LoginUseCase.Params.create(
                    email,
                    password
                )
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { _loading.postValue(false) }
                .subscribe({ _loginSuccess.postValue(it.name) }, { _loginFailed.postValue(it) })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    private fun isFormValid(email: String, password: String): Boolean {
        var result = true

        if (!email.isValidEmail()) {
            _invalidEmail.postValue(Unit)
            result = false
        }

        if (!password.isValidPassword()) {
            _invalidPassword.postValue(Unit)
            result = false
        }

        return result
    }
}
