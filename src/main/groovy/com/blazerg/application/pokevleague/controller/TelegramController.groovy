package com.blazerg.application.pokevleague.controller

import com.blazerg.application.pokevleague.model.Update
import com.blazerg.application.pokevleague.service.MessageService
import com.blazerg.application.pokevleague.service.PokemonService
import groovy.util.logging.Log
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@Api(value = 'TELEGRAM', description = 'The telegram shit')
@Log
@RequestMapping(value = "/listener")
@RestController
class TelegramController {

    @Autowired
    private MessageService messageService

    @Autowired
    private PokemonService pokemonService

    @RequestMapping(value = "/webhook", method = RequestMethod.POST)
    void webhook(@RequestBody Update update) {
        Integer chatId = update.message.getChat().getId()
        String inputMessage = update.message?.text

        log.info("message received $inputMessage")
        log.info("$update")

        if (inputMessage == "/getPoke") {
//            this.messageService.sendNotificationToTelegram("Ninjas sent to your coordinates", chatId)
            this.messageService.sendNotificationToTelegram(pokemonService.getExistingPoke().getName(), chatId)
            log.info("Poke retrieved from the pokeApi")
        }
    }
}
