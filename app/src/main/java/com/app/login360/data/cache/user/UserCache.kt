package com.app.login360.data.cache.user

import com.app.login360.data.model.User
import io.reactivex.Completable
import io.reactivex.Single

interface UserCache {
    fun saveUser(user: User): Completable
    fun getSavedUser(): Single<User>
}