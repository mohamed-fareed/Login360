package com.app.login360.data

import com.app.login360.data.cache.user.UserCache
import com.app.login360.data.model.User
import com.app.login360.data.remote.user.UserRemote
import com.app.login360.domain.repostories.UserRepository
import com.app.login360.domain.usecases.LoginUseCase
import io.reactivex.Completable
import io.reactivex.Single

class UserDataRepository(
    private val userCache: UserCache, private val userRemote: UserRemote
) : UserRepository {
    override fun getSavedUser(): Single<User> = userCache.getSavedUser()

    override fun login(loginRequest: LoginUseCase.Params): Single<User> =
        userRemote.login(loginRequest)

    override fun saveUser(user: User): Completable = userCache.saveUser(user)

    override fun logout(user: User): Completable = userCache.deleteUser(user)
}