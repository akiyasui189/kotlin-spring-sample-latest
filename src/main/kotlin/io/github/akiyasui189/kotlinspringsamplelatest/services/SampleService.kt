package io.github.akiyasui189.kotlinspringsamplelatest.services

import io.github.akiyasui189.kotlinspringsamplelatest.repositories.SendMessageRepository
import org.springframework.stereotype.Service

@Service
class SampleService (
    val repository: SendMessageRepository
) {

    fun postSimpleMessage(message: String) {
        repository.postSimpleMessage(message)
    }

    // FIXME: use deprecated implementations
    fun postSimpleMessageDeprecated(message: String) {
        repository.postSimpleMessageDeprecated(message)
    }

}