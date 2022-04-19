package io.github.akiyasui189.kotlinspringsamplelatest.infrastructures

import io.github.akiyasui189.kotlinspringsamplelatest.infrastructures.constants.MessageQueueConstants
import org.springframework.cloud.stream.annotation.Input
import org.springframework.messaging.SubscribableChannel

interface SimpleMessageInputChannel {

    @Input(MessageQueueConstants.SIMPLE_MESSAGE_EVENT)
    fun subscribeSimpleMessage(): SubscribableChannel

    @Input(MessageQueueConstants.SIMPLE_MESSAGE_EVENT_DLQ)
    fun subscribeSimpleMessageDlq(): SubscribableChannel

}