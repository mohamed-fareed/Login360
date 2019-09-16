package com.app.login360.data.cache.user

import com.app.login360.data.cache.AppDatabase
import com.app.login360.data.model.User
import io.reactivex.Completable
import io.reactivex.Single

class UserCacheImp(private val appDatabase: AppDatabase) : UserCache {
    override fun saveUser(user: User): Completable = appDatabase.userDao().insertAll(user)

    override fun getSavedUser(): Single<User> = appDatabase.userDao().getSavedUser()
}