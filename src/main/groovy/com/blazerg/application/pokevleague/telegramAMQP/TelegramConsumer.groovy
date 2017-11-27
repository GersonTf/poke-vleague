package com.blazerg.application.pokevleague.telegramAMQP

import com.blazerg.application.pokevleague.service.TelegramHandlerService
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RabbitListener(queues = "telegramQueue")
class TelegramConsumer {

    @Autowired
    TelegramHandlerService telegramHandler

    @RabbitHandler
    void receive(String input) {
        def splitter = input.split("\\|")
        //TODO 404 response bug after passing through GlobalExceptionHandler
        this.telegramHandler.messageReceiver(splitter[0], splitter[1])
        println(" [x] Received '" + input + "'")
    }
}
