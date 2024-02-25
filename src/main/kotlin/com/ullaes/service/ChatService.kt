package com.ullaes.service

import com.ullaes.client.OllamaApiClient
import com.ullaes.service.dto.SentimentAnalysisResult
import org.springframework.ai.chat.prompt.PromptTemplate
import org.springframework.ai.parser.BeanOutputParser
import org.springframework.stereotype.Service

@Service
class ChatService(
    private val client : OllamaApiClient
) {

    private val promptTemplate = PromptTemplate("""
        Какое настроение у следующего текста:'{text}'? 
        Оно позитивное, негативное или нейтральное? 
        Укажи степень уверенности с помощью числа от 0.0 до 1.0.{format}"
    """)
    private val outputParser = BeanOutputParser(SentimentAnalysisResult::class.java)

    fun exchange(message: String): SentimentAnalysisResult {
        val prompt = promptTemplate.create(mapOf("text" to message, "format" to outputParser.format))
        val answer = client.sendMessage(prompt)
        return outputParser.parse(answer.output.content)
    }
}