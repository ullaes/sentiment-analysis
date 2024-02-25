package com.ullaes.controller

import com.ullaes.service.ChatService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatController(
    val chatService: ChatService
) {

    @PostMapping("/chat")
    fun sendMessage(@RequestBody message: String): String {
        return chatService.exchange(message)
    }
}