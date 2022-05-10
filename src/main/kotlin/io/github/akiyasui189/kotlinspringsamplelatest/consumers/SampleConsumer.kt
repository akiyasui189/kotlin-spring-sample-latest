package io.github.akiyasui189.kotlinspringsamplelatest.consumers

import io.github.akiyasui189.kotlinspringsamplelatest.infrastructures.constants.MessageQueueConstants
import io.github.akiyasui189.kotlinspringsamplelatest.usecases.SampleUsecase
//import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.stereotype.Component

@Component
class SampleConsumer (
    val usecase: SampleUsecase
) {

    // TODO: Annotation base implementation deprecated.
    //@StreamListener(MessageQueueConstants.SIMPLE_MESSAGE_EVENT)
    fun subscribeSimpleMessageEvent(message: String) {
        // TODO: implements for sample
        println("### message: ${message}")
    }

    // TODO: Annotation base implementation deprecated.
    //@StreamListener(MessageQueueConstants.SIMPLE_MESSAGE_EVENT_DLQ)
    fun subscribeSimpleMessageEventDlq(message: String) {
        // TODO: handling error
        println("### DLQ message: ${message}")
    }


}