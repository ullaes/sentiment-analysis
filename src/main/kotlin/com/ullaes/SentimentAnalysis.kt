package com.ullaes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@SpringBootApplication
@ComponentScan(basePackages = ["com.ullaes"])
class SentimentAnalysis

fun main(args: Array<String>) {
    runApplication<SentimentAnalysis>(*args)
}
