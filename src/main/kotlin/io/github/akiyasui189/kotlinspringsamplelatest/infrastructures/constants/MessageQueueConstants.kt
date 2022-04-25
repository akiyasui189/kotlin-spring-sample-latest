package io.github.akiyasui189.kotlinspringsamplelatest.infrastructures.constants

class MessageQueueConstants {

    companion object {
        const val SIMPLE_MESSAGE_EVENT : String = "dep-simple-message-event"
        const val SIMPLE_MESSAGE_EVENT_DLQ : String = "dep-simple-message-event-dlq"
    }

}