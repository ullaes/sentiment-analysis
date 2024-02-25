package com.ullaes.service

import com.ullaes.client.OllamaClient
import com.ullaes.service.dto.SentimentAnalysisResult
import org.springframework.ai.chat.prompt.PromptTemplate
import org.springframework.ai.parser.BeanOutputParser
import org.springframework.stereotype.Service

@Service
class ChatService(
    val client : OllamaClient
) {

    private val promptTemplate = PromptTemplate("""
        What is the sentiment of the following text:'{text}'? 
        Is it positive, negative, or neutral? 
        Specify the degree of confidence as a number from 0.0 to 1.0.{format}"
    """)
    private val outputParser = BeanOutputParser(SentimentAnalysisResult::class.java)

    fun exchange(message: String): String {
        val prompt = promptTemplate.create(mapOf("text" to message, "format" to outputParser.format))
        val answer = client.sendMessage(prompt)
        val analysis = outputParser.parse(answer.output.content)
        return analysis.toString()
    }
}