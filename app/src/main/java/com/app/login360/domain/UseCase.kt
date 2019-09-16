package com.app.login360.domain

import io.reactivex.Single

interface SingleUseCase<I, O> {
    fun execute(params: I): Single<O>
}