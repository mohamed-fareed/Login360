package com.app.login360.data.remote

import com.app.login360.data.model.User
import com.app.login360.domain.usecases.LoginUseCase
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("login")
    fun login(@Body loginRequest: LoginUseCase.Params): Single<User>
}