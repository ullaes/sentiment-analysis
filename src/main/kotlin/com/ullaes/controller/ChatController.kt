package com.ullaes.controller

import com.ullaes.service.ChatService
import com.ullaes.service.dto.SentimentAnalysisResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatController(
    private val chatService: ChatService
) {

    @PostMapping("/chat")
    fun sendMessage(@RequestBody message: String): SentimentAnalysisResult {
        return chatService.exchange(message)
    }
}