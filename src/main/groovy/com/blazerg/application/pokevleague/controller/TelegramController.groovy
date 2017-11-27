package com.blazerg.application.pokevleague.controller

import com.blazerg.application.pokevleague.model.telegramModel.Update
import com.blazerg.application.pokevleague.service.MessageService
import com.blazerg.application.pokevleague.service.PokemonService
import com.blazerg.application.pokevleague.service.TelegramHandlerService
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
    private MessageService messageService

    @Autowired
    private PokemonService pokemonService

    @Autowired
    private TelegramHandlerService telegramHandler

    @RequestMapping(value = "/webhook", method = RequestMethod.POST)
    void webhook(@RequestBody Update update) {
        String chatId = update?.message?.getChat()?.getId()
        String inputMessage = update?.message?.text

        log.info("message received $inputMessage")
        log.info("$update")

        this.telegramHandler.messageReceiver(inputMessage.substring(1), chatId)

//        if (inputMessage == "/getPoke") {
//            this.messageService.sendNotificationToTelegram(pokemonService.getExistingPoke().getName(), chatId)
//            log.info("Poke retrieved from the pokeApi")
//        }
    }
}
