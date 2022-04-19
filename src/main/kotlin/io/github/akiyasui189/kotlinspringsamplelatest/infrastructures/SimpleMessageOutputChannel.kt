package io.github.akiyasui189.kotlinspringsamplelatest.infrastructures

import io.github.akiyasui189.kotlinspringsamplelatest.infrastructures.constants.MessageQueueConstants
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

interface SimpleMessageOutputChannel {

    @Output(MessageQueueConstants.SIMPLE_MESSAGE_EVENT)
    fun publishSimpleMessage(): MessageChannel

}