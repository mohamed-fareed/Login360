package com.app.login360.data.remote.user

import com.app.login360.data.model.User
import com.app.login360.data.remote.ApiInterface
import com.app.login360.domain.usecases.LoginUseCase
import io.reactivex.Single

class UserRemoteImp(private val apiInterface: ApiInterface) : UserRemote {
    override fun login(loginRequest: LoginUseCase.Params): Single<User> =
        apiInterface.login(loginRequest)
}