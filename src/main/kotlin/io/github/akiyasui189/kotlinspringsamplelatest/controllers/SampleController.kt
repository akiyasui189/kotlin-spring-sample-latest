package io.github.akiyasui189.kotlinspringsamplelatest.controllers

import io.github.akiyasui189.kotlinspringsamplelatest.dto.SampleSimpleMessageRequest
import io.github.akiyasui189.kotlinspringsamplelatest.usecases.SampleUsecase
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/sample")
class SampleController (
    val usecase: SampleUsecase
) {

    @PostMapping(
        path = ["/simple/message"],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun postMessage (@RequestBody @Valid requestBody: SampleSimpleMessageRequest) : ResponseEntity<String> {
        usecase.postSimpleMessage(requestBody.message ?: return ResponseEntity.badRequest().body("NG"))
        return ResponseEntity.ok("OK")
    }

}