package com.app.login360.domain.usecases

import com.app.login360.domain.CompletableUseCase
import com.app.login360.domain.repostories.UserRepository
import io.reactivex.Completable

class LogoutUseCase(private val userRepository: UserRepository) : CompletableUseCase<Unit> {
    override fun execute(params: Unit): Completable {
        return userRepository.getSavedUser().flatMapCompletable {
            userRepository.logout(it)
        }
    }
}