package com.ullaes.client

import com.ullaes.configuration.OllamaClientProperties
import org.springframework.ai.chat.Generation
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.ai.ollama.OllamaChatClient
import org.springframework.ai.ollama.api.OllamaApi
import org.springframework.ai.ollama.api.OllamaOptions
import org.springframework.stereotype.Component


@Component
class OllamaApiClient(
    properties: OllamaClientProperties
) {

    private final var client = OllamaChatClient(OllamaApi(properties.url))

    init {
        val options = OllamaOptions.create()
        options.model = properties.options.model
        options.temperature = properties.options.temperature
        options.topK = properties.options.topK
        options.topP = properties.options.topP
        options.frequencyPenalty = properties.options.frequencyPenalty
        options.presencePenalty = properties.options.presencePenalty
        client.withDefaultOptions(options)
    }

    fun sendMessage(prompt: Prompt): Generation {
        val response = client.call(prompt)
        return response.result
    }
}