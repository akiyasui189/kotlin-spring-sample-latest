package io.github.akiyasui189.kotlinspringsamplelatest.repositories

import io.github.akiyasui189.kotlinspringsamplelatest.infrastructures.SimpleMessageOutputChannel
import org.springframework.messaging.Message
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Repository

@Repository
class ProvideMessageRepository (
    val dao: SimpleMessageOutputChannel
) {

    fun postSimpleMessage(payload: String) {
        try {
            // send message to kafka via Spring Cloud Stream
            val headers = HashMap<String, Any>()
            headers["version"] = "1.0"
            val messageHeaders = MessageHeaders(headers)
            val message : Message<String> = MessageBuilder.createMessage(payload, messageHeaders)
            val res: Boolean = dao.publishSimpleMessage().send(message)
            if (!res) {
                throw RuntimeException("Send Message Error.")
            }
        } catch (ex: Exception) {
            throw RuntimeException("Send Message Failed by Unknown Error.", ex)
        }
    }

}