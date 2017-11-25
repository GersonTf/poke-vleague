package com.blazerg.application.pokevleague.controller

import com.blazerg.application.pokevleague.model.Update
import com.blazerg.application.pokevleague.service.MessageService
import groovy.util.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@Log
@RequestMapping(value = "/listener")
@RestController
class TelegramController {

    @Autowired
    MessageService messageService

    @RequestMapping(value = "/webhook", method = RequestMethod.POST)
    void webhook(@RequestBody Update update) {
        Integer chatId = update.message.getChat().getId()
        String inputMessage = update.message?.text

        log.info("message received $inputMessage")
        log.info("$update")

        if(inputMessage == "/getPoke"){
            this.messageService.sendNotificationToTelegram(update.message?.text, chatId)
        }
    }
}
