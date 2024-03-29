package com.ullaes.configuration

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration


@Configuration
@EnableConfigurationProperties(OllamaClientProperties::class)
class OllamaConfiguration {
}