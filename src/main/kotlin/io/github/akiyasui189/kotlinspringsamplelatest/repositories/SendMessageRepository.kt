package io.github.akiyasui189.kotlinspringsamplelatest.repositories

import io.github.akiyasui189.kotlinspringsamplelatest.dto.SampleSimpleMessage
import io.github.akiyasui189.kotlinspringsamplelatest.infrastructures.SimpleMessageOutputChannel
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.http.MediaType
import org.springframework.messaging.Message
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Repository

@Repository
class SendMessageRepository (
    //val dao: SimpleMessageOutputChannel,
    val streamBridge: StreamBridge
) {

    fun postSimpleMessage(message: String) {
        try {
            // send message to kafka via Spring Cloud Stream
            println("### produce message: $message")
            val res = streamBridge.send("mqSimpleMessageProducer-out-0", SampleSimpleMessage(message))
            if (!res) {
                throw RuntimeException("Send Message Error.")
            }
        } catch (ex: Exception) {
            throw RuntimeException("Send Message Failed by Unknown Error.", ex)
        }
    }

    /**
     * FIXME: Annotation base implementation deprecated.
     */
    fun postSimpleMessageDeprecated(payload: String) {
        this.postSimpleMessage(payload)
//        try {
//            // send message to kafka via Spring Cloud Stream
//            val headers = HashMap<String, Any>()
//            headers["version"] = "1.0"
//            val messageHeaders = MessageHeaders(headers)
//            val message : Message<String> = MessageBuilder.createMessage(payload, messageHeaders)
//            val res: Boolean = dao.publishSimpleMessage().send(message)
//            if (!res) {
//                throw RuntimeException("Send Message Error.")
//            }
//        } catch (ex: Exception) {
//            throw RuntimeException("Send Message Failed by Unknown Error.", ex)
//        }
    }

}