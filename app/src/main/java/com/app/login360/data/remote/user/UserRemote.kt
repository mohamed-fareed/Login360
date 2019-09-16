package com.app.login360.data.remote.user

import com.app.login360.data.model.User
import com.app.login360.domain.usecases.LoginUseCase
import io.reactivex.Single

interface UserRemote {
    fun login(loginRequest: LoginUseCase.Params): Single<User>
}