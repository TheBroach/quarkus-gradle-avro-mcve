package com.example.quarkus.gradle.avro.application

import com.example.quarkus.gradle.avro.UserCreationRequest
import io.github.oshai.kotlinlogging.KotlinLogging
import io.quarkus.runtime.StartupEvent
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.event.Observes

@ApplicationScoped
class Starter {
    private val log = KotlinLogging.logger {  }
    private lateinit var userCreationRequest: UserCreationRequest

    fun appStart(@Observes startupEvent: StartupEvent) = log.info { "Hello from Quarkus" }
}