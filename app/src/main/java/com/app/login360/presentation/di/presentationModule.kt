package com.app.login360.presentation.di

import com.app.login360.presentation.screens.home.HomeViewModel
import com.app.login360.presentation.screens.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { LoginViewModel(getLoggedInUseCase = get(), loginUseCase = get()) }
    viewModel { HomeViewModel() }
}