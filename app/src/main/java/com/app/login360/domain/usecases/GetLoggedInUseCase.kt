package com.app.login360.domain.usecases

import com.app.login360.data.model.User
import com.app.login360.domain.SingleUseCase
import com.app.login360.domain.repostories.UserRepository
import io.reactivex.Single

class GetLoggedInUseCase(
    private val userRepository: UserRepository
) : SingleUseCase<Unit, User> {
    override fun execute(params: Unit): Single<User> =
        userRepository.getSavedUser()
}