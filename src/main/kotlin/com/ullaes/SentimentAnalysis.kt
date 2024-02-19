package com.ullaes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class SentimentAnalysis

fun main(args: Array<String>) {
    runApplication<SentimentAnalysis>(*args)
}
