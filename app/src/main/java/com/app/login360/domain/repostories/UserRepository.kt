package com.app.login360.domain.repostories

import com.app.login360.data.model.User
import com.app.login360.domain.usecases.LoginUseCase
import io.reactivex.Completable
import io.reactivex.Single

interface UserRepository {
    fun getSavedUser(): Single<User>
    fun login(loginRequest: LoginUseCase.Params): Single<User>
    fun saveUser(user: User): Completable
    fun logout(user: User): Completable
}