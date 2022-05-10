package io.github.akiyasui189.kotlinspringsamplelatest.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
//import javax.validation.constraints.NotEmpty
//import javax.validation.constraints.NotNull

data class SampleSimpleMessageRequest (
    @field:NotNull
    @field:NotEmpty
    val message: String?
)