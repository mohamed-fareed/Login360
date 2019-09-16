package com.app.login360.domain.di

import com.app.login360.domain.usecases.GetLoggedInUseCase
import com.app.login360.domain.usecases.LoginUseCase
import org.koin.dsl.module

val domainModule = module {
    single { LoginUseCase(userRepository = get()) }
    single { GetLoggedInUseCase(userRepository = get()) }
}