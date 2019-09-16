package com.app.login360.data.cache.user

import com.app.login360.data.cache.AppDatabase
import com.app.login360.data.model.User
import io.reactivex.Single

class UserCacheImp(private val appDatabase: AppDatabase) : UserCache {
    override fun saveUser(user: User) {
        appDatabase.userDao().insertAll(user)
    }

    override fun getSavedUser(): Single<User> {
        return Single.just(appDatabase.userDao().getSavedUser())
    }
}