package com.app.login360.presentation.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.login360.data.model.User
import com.app.login360.domain.usecases.GetLoggedInUseCase
import com.app.login360.domain.usecases.LogoutUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(
    private val getLoggedInUseCase: GetLoggedInUseCase,
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _userData = MutableLiveData<User>()
    val userData: LiveData<User> = _userData

    private val _userLoggedOut = MutableLiveData<Unit>()
    val userLoggedOut: LiveData<Unit> = _userLoggedOut

    private val compositeDisposable = CompositeDisposable()

    init {
        getUser()
    }

    private fun getUser() {
        _loading.postValue(true)

        compositeDisposable.add(
            getLoggedInUseCase.execute(Unit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { _loading.postValue(false) }
                .subscribe({
                    _userData.postValue(it)
                }, {})
        )
    }

    fun logout() {
        _loading.postValue(true)

        compositeDisposable.add(
            logoutUseCase.execute(Unit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { _loading.postValue(false) }
                .subscribe({
                    _userLoggedOut.postValue(Unit)
                }, {})
        )
    }
}
