package com.app.login360.data.di

import android.content.Context
import androidx.room.Room
import com.app.login360.data.UserDataRepository
import com.app.login360.data.cache.AppDatabase
import com.app.login360.data.cache.user.UserCache
import com.app.login360.data.cache.user.UserCacheImp
import com.app.login360.data.remote.ApiInterface
import com.app.login360.data.remote.user.UserRemote
import com.app.login360.data.remote.user.UserRemoteImp
import com.app.login360.domain.repostories.UserRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit

val dataModule = module {
    // user repo
    single { provideApi(get()) }

    // user repo
    single { UserDataRepository(userCache = get(), userRemote = get()) as UserRepository }
    single { UserCacheImp(appDatabase = get()) as UserCache }
    single { UserRemoteImp(apiInterface = get()) as UserRemote }

    // database
    single { provideRoom(androidContext()) }
}

private fun provideApi(retrofit: Retrofit) = retrofit.create(ApiInterface::class.java)

private fun provideRoom(context: Context) =
    Room.databaseBuilder(context, AppDatabase::class.java, "login360").build()