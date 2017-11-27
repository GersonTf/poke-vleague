package com.blazerg.application.pokevleague.telegramAMQP

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

/**
 * sender class for rabbitMQ
 */
@Service
class TelegramSender {

    @Autowired
    private RabbitTemplate template

    @Autowired
    private Queue queue

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    void send() {
        String message = "Hello World!"
        this.template.convertAndSend(queue.getName(), message)
        System.out.println(" [x] Sent '" + message + "'")
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    void send(String message) {
        this.template.convertAndSend(queue.getName(), message)
        System.out.println(" [x] Sent '" + message + "'")
    }
}