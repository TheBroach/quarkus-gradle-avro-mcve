package com.example.quarkus.gradle.avro.adapters

import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class KafkaAdapter {
    private lateinit var userCreationRequest: Any
}