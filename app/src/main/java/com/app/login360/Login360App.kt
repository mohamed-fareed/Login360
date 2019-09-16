package com.app.login360

import android.app.Application
import com.app.login360.data.di.dataModule
import com.app.login360.data.di.networkModule
import com.app.login360.domain.di.domainModule
import com.app.login360.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Login360App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@Login360App)
            modules(
                listOf(
                    networkModule,
                    dataModule,
                    domainModule,
                    presentationModule
                )
            )
        }
    }
}