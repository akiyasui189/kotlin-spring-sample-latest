package io.github.akiyasui189.kotlinspringsamplelatest.usecases

import io.github.akiyasui189.kotlinspringsamplelatest.services.SampleService
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class SampleUsecase (
    val service: SampleService
) {

    @Transactional
    fun postSimpleMessage(message: String) {
        service.postSimpleMessage(message)
    }
}