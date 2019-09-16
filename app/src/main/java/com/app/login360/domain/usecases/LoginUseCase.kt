package com.app.login360.domain.usecases

import com.app.login360.data.model.User
import com.app.login360.domain.SingleUseCase
import com.app.login360.domain.repostories.UserRepository
import io.reactivex.Single

class LoginUseCase(
    private val userRepository: UserRepository
) : SingleUseCase<LoginUseCase.Params, User> {

    override fun execute(params: Params): Single<User> =
        userRepository.login(params).map { user ->
            userRepository.saveUser(user).subscribe()
            user
        }

    class Params private constructor(val email: String, val password: String) {
        companion object {
            fun create(email: String, password: String): Params = Params(email, password)
        }
    }
}