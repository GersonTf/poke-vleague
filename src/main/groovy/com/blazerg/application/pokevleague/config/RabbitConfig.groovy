package com.blazerg.application.pokevleague.config

import com.blazerg.application.pokevleague.telegramAMQP.TelegramConsumer
import com.blazerg.application.pokevleague.telegramAMQP.TelegramSender
import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Profile(["telegramQueue","telegram-bot"])
@Configuration
class RabbitConfig {

    @Bean
    Queue hello() {
        return new Queue("telegramQueue")
    }

    @Profile("receiver")
    @Bean
    TelegramConsumer receiver() {
        return new TelegramConsumer()
    }

    @Profile("sender")
    @Bean
    TelegramSender sender() {
        return new TelegramSender()
    }
}