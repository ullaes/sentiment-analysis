package com.ullaes.service

import com.ullaes.client.OllamaClient
import org.springframework.stereotype.Service

@Service
class ChatService(
    val client : OllamaClient
) {


    fun exchange(message: String): String {
        return client.sendMessage(message)
    }
}