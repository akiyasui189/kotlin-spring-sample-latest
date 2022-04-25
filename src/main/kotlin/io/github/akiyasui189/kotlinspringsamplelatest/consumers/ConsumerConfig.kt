package io.github.akiyasui189.kotlinspringsamplelatest.consumers

import io.github.akiyasui189.kotlinspringsamplelatest.dto.SampleSimpleMessage
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.function.Consumer

@Configuration
class ConsumerConfig {

    @Bean
    open fun mqSimpleMessageConsumer() = Consumer<SampleSimpleMessage> {
        println("### consumer: ${it.message}")
    }

    @Bean
    open fun mqSimpleMessageProcessor() : (SampleSimpleMessage) -> SampleSimpleMessage {
        return {
            println("### processor: ${it.message}")
            it
        }
    }

}