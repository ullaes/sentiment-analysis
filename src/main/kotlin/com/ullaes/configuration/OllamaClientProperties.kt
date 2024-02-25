package com.ullaes.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "ai.ollama")
data class OllamaClientProperties(
    val url: String,
    val options: OllamaOptions
)

data class OllamaOptions(
    val model: String,
    val temperature: Float
)
