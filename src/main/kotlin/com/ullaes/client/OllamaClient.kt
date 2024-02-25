package com.ullaes.client

import com.ullaes.configuration.OllamaClientProperties
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.ai.ollama.OllamaChatClient
import org.springframework.ai.ollama.api.OllamaApi
import org.springframework.ai.ollama.api.OllamaOptions
import org.springframework.stereotype.Component


@Component
class OllamaClient(
    properties: OllamaClientProperties
) {

    final var client = OllamaChatClient(OllamaApi(properties.url))

    init {
        val options = OllamaOptions.create()
        options.model = properties.options.model
        options.temperature = properties.options.temperature
        client.withDefaultOptions(options)
    }

    fun sendMessage(message: String): String {
        val prompt = Prompt(message)
        val response = client.call(prompt)
        return response.result.output.content
    }
}