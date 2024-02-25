package com.ullaes.service.dto

data class SentimentAnalysisResult(
    val text: String = "",
    val sentiment: String = "",
    val confidence: Double = 0.0
)
