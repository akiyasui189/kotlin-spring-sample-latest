package io.github.akiyasui189.kotlinspringsamplelatest

import io.github.akiyasui189.kotlinspringsamplelatest.infrastructures.SimpleMessageInputChannel
import io.github.akiyasui189.kotlinspringsamplelatest.infrastructures.SimpleMessageOutputChannel
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding

@EnableBinding(
	SimpleMessageInputChannel::class,
	SimpleMessageOutputChannel::class
)
@SpringBootApplication
class KotlinSpringSampleLatestApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringSampleLatestApplication>(*args)
}
