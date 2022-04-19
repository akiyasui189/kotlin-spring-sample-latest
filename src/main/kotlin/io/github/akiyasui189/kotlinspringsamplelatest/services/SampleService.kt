package io.github.akiyasui189.kotlinspringsamplelatest.services

import io.github.akiyasui189.kotlinspringsamplelatest.repositories.ProvideMessageRepository
import org.springframework.stereotype.Service

@Service
class SampleService (
    val repository: ProvideMessageRepository
) {

    fun postSimpleMessage(message: String) {
        repository.postSimpleMessage(message)
    }

}